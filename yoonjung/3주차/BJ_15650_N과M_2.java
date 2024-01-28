package Backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_15650_N과M_2 {
	static int[] arr;
	static int N, M;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		
		BT(1, 0);
	}
	
	public static void BT(int start, int depth) {
		if(depth == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = start; i <= N; i++) {
			arr[depth] = i;
			BT(i + 1, depth + 1);
 
		}
	}
}

// 오름차순, M의 길이까지 나열 가능한 수열