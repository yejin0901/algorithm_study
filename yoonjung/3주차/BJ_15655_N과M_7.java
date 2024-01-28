package Backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_15655_N과M_7 {
	static int[] arr, arr2;
	static int N, M;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		arr2 = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		BT(0);
		System.out.println(sb);
	}
	
	public static void BT(int depth) {
		if(depth == M) {
			for (int i = 0; i < M; i++) {
				sb.append(arr2[i]).append(' '); // 시간초과 때문에 System.out.print(); 에서 StringBuilder로 변경
			}
			sb.append('\n');
			return;
		}
		
		for (int i = 0; i < N; i++) {
			arr2[depth] = arr[i];
			BT(depth + 1);
		}
	}
}

// 중복 X
// 오름차순
// 백준 14541 N과 M (3)와 같은 경우