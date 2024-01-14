import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2178_미로탐색 {
	static boolean[][] visited;
	static int[][] arr;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int N, M;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N][M];
		arr = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		
		visited[0][0] = true;
		BFS(0, 0);
		System.out.println(arr[N-1][M-1]);
		

	}
	
	public static void BFS(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{x,y});
		
		while(!q.isEmpty()) {
			int now[] = q.poll();
			int nx = now[0];
			int ny = now[1];
			
			for(int i = 0; i < 4; i++) {
				int tx = nx + dx[i];
				int ty = ny + dy[i];
				
				if(tx >= 0 && tx < N && ty >= 0 && ty < M) {
					if(arr[tx][ty] == 1 && !visited[tx][ty]) {
						visited[tx][ty] = true;
						q.add(new int[]{tx,ty});
						arr[tx][ty] = arr[nx][ny] + 1;
					}
				}
			}
		}
	}

}
