package Backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_15649_N과M_1 {
	static boolean[] visited;
	static int[] arr;
	static int N, M;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N + 1];
		arr = new int[M];
		
		Backtracking(0);
	}
	
	public static void Backtracking(int depth) {
		if(depth == M) { // 현재까지 선택한 수가 M개에 도달하면 수열을 출력하고 함수 종료
			for (int i = 0; i < M; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = 0; i < N; i++) { // 1부터 N까지의 숫자 중에서 방문하지 않은 숫자를 선택하여 수열에 추가하고 재귀 호출
			if(!visited[i]) {
				visited[i] = true; // 방문
				arr[depth] = i + 1;
				Backtracking(depth + 1);
				visited[i] = false;
			}
		}
	}
}

// 중복 X
