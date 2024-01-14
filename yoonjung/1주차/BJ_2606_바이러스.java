import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2606_바이러스 {
	static int[][] arr;
	static boolean[] visited;
	static int C_Cnt, S_Cnt;
	static int count = 0;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		C_Cnt = Integer.parseInt(br.readLine());
		S_Cnt = Integer.parseInt(br.readLine());
		
		arr = new int[C_Cnt + 1][C_Cnt + 1];
		visited = new boolean[C_Cnt + 1];
		
		for (int i = 0; i < S_Cnt; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[a][b] = arr[b][a] = 1;						// 양방향
		}
		
		DFS(1);
		System.out.println(count);
		

	}
	
	// 재귀함수 사용
	public static void DFS(int start) {
		visited[start] = true;								// 방문
		
		for (int i = 1; i <= C_Cnt; i++) {					// 컴퓨터의 숫자가 1부터 존재하므로
			if(arr[start][i] == 1 && !visited[i]) { // arr[start][i] == 1 : 간선이 존재 / !visited[i] : 아직 방문하지 않음
				count++;
				DFS(i);
			}
		}
	}

}
