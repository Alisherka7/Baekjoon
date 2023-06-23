import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static class BridgeInfo{
		int end, weight;
		public BridgeInfo(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}
	}
	static List <BridgeInfo> []bridgeInfo;
	static int isGemsIsland[]= new int[101];
	static boolean [][]visited =  new boolean [1<<16][101];
	static int N,M,K, result;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =  new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		result=Integer.MIN_VALUE;
		
		bridgeInfo=new List[N+2];
		
		for(int i=0; i<=N+1; i++) {
			bridgeInfo[i] =  new ArrayList<>();
		}
		
		Arrays.fill(isGemsIsland, -1);
		for(int i=0; i<K; i++) {
			int gemIndex = Integer.parseInt(br.readLine());
			isGemsIsland[gemIndex]=i;
		}
		
		for(int i=0; i<M; i++) {
			st =  new StringTokenizer(br.readLine());
			int start=Integer.parseInt(st.nextToken());
			int end=Integer.parseInt(st.nextToken());
			int weight=Integer.parseInt(st.nextToken());
			
			bridgeInfo[start].add(new BridgeInfo(end, weight));
			bridgeInfo[end].add(new BridgeInfo(start, weight));
		}
		bridgeInfo[1].add(new BridgeInfo(1, 1000));
		
		solve(1,0,0);
		System.out.println(result);
	}
	private static void solve(int curIsland, int curState, int curGemCnt) {
		visited[curState][curIsland]=true;
		if(curIsland==1) {
			result=Math.max(curGemCnt, result);
		}
		
		boolean isGemCurIsland = (isGemsIsland[curIsland]!=-1) ? true : false;		
		int nextState = (curState | (1<<isGemsIsland[curIsland]) );
		int size=bridgeInfo[curIsland].size();
		
		for(int i=0; i<size; i++) {
			BridgeInfo info = bridgeInfo[curIsland].get(i);
			if(!visited[curState][info.end] && info.weight>=curGemCnt) {
				solve(info.end,  curState, curGemCnt); 
			}
			
			if(isGemCurIsland) { 
				if((curState & (1<<isGemsIsland[curIsland]))>0) continue;
				if(info.weight<curGemCnt+1 || visited[nextState][info.end]) continue; 
				solve(info.end, nextState, curGemCnt+1);
			}
			
		}
	}

}
