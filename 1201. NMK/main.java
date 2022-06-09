import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int[] nums = new int[n];
        for(int i=0; i < n; i++){
            nums[i] = i+1;
        }
        
        // 최소범위 : M+K-1
        // 최대범위 : MK
        if(n < m+k-1 || m*k < n) {
            System.out.println(-1);
            return;
        }
        
        // 그룹을 맺을 start / end 부분을 저장하는 list
        Deque<Integer> list = new LinkedList<>();
        
        // 처음에는 0부터 k-1까지 저장해야 하므로 0과 k를 각각 start / end로 지정한다.
        list.offer(0); list.offer(k);
        n -= k;  // k개의 데이터는 사용 완료이므로 k를 뺀다.
        m -= 1;  // 1개의 그룹이 생성되었으므로 1을 뺀다.
        
        // 1개의 그룹을 만들었으니 나머지 그룹을 만들기 위해 필요한 크기를 구한다.
        // m == 0이면 추가 필요 그룹이 없으니 0으로 지정한다.
        // 0이 아니면 n/m 만큼의 크기로 그룹을 만들어야 한다.
        int groupSize = m == 0 ? 0 : n/m;
        
        // 나머지 값이 있다면 그 수만큼 다른 그룹에 +1씩해서 나누면 된다.
        int r = m == 0 ? 0 : n%m;
        
        // 그룹의 End부분을 계속 넣는다.
        for(int i=0; i < m; i++){
            list.offer(list.getLast() + groupSize + (r > 0 ? 1 : 0));
            if(r > 0) r--;  // 나머지가 아직 남아있으면 빼준다.
        }
        
        StringBuilder sb = new StringBuilder();
        
        // start, end값을 빼서 내부 배열의 값을 모두 반전시킨다.
        int start = 0; int end = list.pollFirst();
        while(!list.isEmpty()){
            start = end;
            end = list.pollFirst();
            
            // end-1부터 start까지 reverse하여 붙힌다.
            for(int j=end-1; j >= start; j--){
                sb.append(nums[j]).append(" ");
            }
        }
        
        System.out.println(sb);
        br.close();
    }
}
