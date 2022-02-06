import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] map = new int[8][8];
	static int x,y,sx,sy;
	//R,L,B,T,RT,LT,RB,LB
	static int[] dy= {0,0,-1,1,1,1,-1,-1};
	static int[] dx= {1,-1,0,0,1,-1,1,-1};
	public static void go (String A,int x1,int y1,int state) {
		int dir=0;
		
		switch(A) {
		case "R":
			 dir = 0;
			 break;
		case "L":
			dir = 1;
			break;
		case "B":
			dir= 2;
			break;
		case "T":
			dir = 3;
			break;
		case "RT":
			dir = 4;
			break;
		case "LT":
			dir = 5;
			break;
		case "RB":
			dir = 6;
			break;
		case "LB":
			dir = 7;
			break;
		}
		
		int nx = x1+dx[dir];
		int ny = y1+dy[dir];
		//범위를 벗어나는경우
		if(nx<0||ny<0||nx>=8||ny>=8) return;
		//돌이 이동하려고 하는곳에 있는경우
		if(map[nx][ny]==2) {
			//STATE 2로 변경해주고 GO 메소드 사용
			go(A,nx,ny,2);
			//돌이 밖으로 나가지 않은 경우를 확인하기 위한 조건문
			//돌이 밖으로 나가면 킹도 같이 나가면 안된다.
			if(map[nx][ny]==0) {
			map[x][y]=0;
			x=nx;
			y=ny;
			map[x][y]=1;
			}
			return;
		}
		//돌이 이동하는 경우
		if(state==2) {
			map[sx][sy]=0;
			sx=nx;
			sy=ny;
			map[sx][sy]=2;
			return;
		}

		//킹이 이동하는 경우
		map[x][y]=0;
		x=nx;
		y=ny;
		map[x][y]=1;

		return;
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//킹의 위치
		String king = st.nextToken();
		x =king.charAt(0)-'A';
		y =king.charAt(1)-'1';

		map[x][y]=1;
		//돌의 위치
		String stone = st.nextToken();
		sx = stone.charAt(0)-'A';
		sy = stone.charAt(1)-'1';

		map[sx][sy]=2;
		int move = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < move; i++) {
			st = new StringTokenizer(br.readLine(),"  ");
			String A = st.nextToken();
			go(A,x,y,1);
		}
		char result = (char) (x+'A');
		char result2= (char) (sx+'A');
		//1로 빼주었기 때문에 +1 해야한다.
		System.out.println(result+""+(y+1));
		System.out.println(result2+""+(sy+1));
	}
}
