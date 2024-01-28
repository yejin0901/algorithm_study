package Backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_15652_N과M_4 {
	static int N, M;
	static int[] arr;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
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
			BT(i, depth + 1);
		}
	}
}

// 중복 O
// 비내림차순 != 오름차순