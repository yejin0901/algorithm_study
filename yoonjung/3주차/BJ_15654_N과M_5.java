package Backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_15654_N과M_5 {
	static boolean[] visited;
	static int[] arr, arr2;
	static int N, M;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N+1];
		arr = new int[N];
		arr2 = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		BT(0);
	}
	
	public static void BT(int depth) {
		if(depth == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(arr2[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true; // 방문
				arr2[depth] = arr[i];
				BT(depth + 1);
				visited[i] = false;
			}
		}
	}
}

// 중복 X
// 오름차순
// 백준 15649 N과 M (1)과 같은 경우
