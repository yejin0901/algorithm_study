import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1260_DFS와BFS {
	
	static int N, M, V;
	static boolean[] visited;
	static int[][] arr;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 정점의 개수
		M = Integer.parseInt(st.nextToken()); // 간선의 개수
		V = Integer.parseInt(st.nextToken()); // 탐색을 시작할 정점의 번호
		
		arr = new int[N+1][N+1];
		visited = new boolean[N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[a][b] = arr[b][a] = 1; // 양방향
		}
		
		DFS(V);
		System.out.println("");
		visited = new boolean[N+1];						// BFS를 수행하기 위해 초기화
		
		BFS(V);
		System.out.println("");

	}
	
	// DFS(깊이) -> Stack or 재귀함수 사용
	// 재귀함수 사용
	public static void DFS(int start) {
		visited[start] = true; 							// 현재 노드를 방문 처리
		System.out.print(start + " "); 					// 방문한 노드 출력
		
		for (int i = 1; i <= N; i++) {
			if(arr[start][i] == 1 && !visited[i]) { 	// arr[start][i] == 1 : 간선이 존재 / !visited[i] : 아직 방문하지 않음  
				DFS(i);
			}
		}
	}
	
	// BFS(너비) -> Queue 사용
	public static void BFS(int start) {
		visited[start] = true; 							// 현재 노드를 방문 처리
		
		Queue<Integer> q = new LinkedList<>();
		q.add(start); 									// 시작 노드를 Queue에 add
		
		while(!q.isEmpty()) {
			int now = q.poll();
			System.out.print(now + " ");				// Queue에서 poll한 노드 출력
			for (int i = 1; i <= N; i++) {
				if(arr[now][i] == 1 && !visited[i]) {
					visited[i] = true;
					q.add(i);
				}
			}
		}
	}

}
