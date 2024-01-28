package Backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_15664_N과M_10 {
	static int[] arr, arr2;
	static int N, M;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		arr2 = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		BT(0, 0);
	}
	
	public static void BT(int start, int depth) {
		if(depth == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(arr2[i] + " ");
			}
			System.out.println();
			return;
		}
		
		int before = 0;
		for (int i = start; i < N; i++) {
			if(before != arr[i]) {
				arr2[depth] = arr[i];
				before = arr[i];
				BT(i + 1, depth + 1);
			}
		}
	}
	
}

// (2), (6)와 같은 경우
