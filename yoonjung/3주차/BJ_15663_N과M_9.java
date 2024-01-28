package Backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_15663_N과M_9 {
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
		
		int before = 0;
		for (int i = 0; i < N; i++) {
			if(!visited[i] && before != arr[i]) {
				visited[i] = true; // 방문
				arr2[depth] = arr[i];
				before = arr[i];
				BT(depth + 1);
				visited[i] = false;
			}
		}
	}
}

// (1), (5)와 같은 경우
// 단, N개의 수에 같은 수가 존재