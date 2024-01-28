package Backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_15651_N과M_3 {
	static int[] arr;
	static int N, M;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		
		BT(0);
		System.out.println(sb);
	}
	
	public static void BT(int depth) {
		if(depth == M) {
			for (int i = 0; i < M; i++) {
				sb.append(arr[i]).append(' '); // 시간초과 때문에 System.out.print(); 에서 StringBuilder로 변경
			}
			sb.append('\n');
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			arr[depth] = i;
			BT(depth + 1);
		}
	}
}

// 중복 O