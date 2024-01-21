package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_2217_로프 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] rope = new int[N];
		
		for (int i = 0; i < N; i++) {
			rope[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(rope);
		
		int max = 0;
		
		for (int i = 0; i < N; i++) {
			max = Math.max(max, rope[i] * (N - i)); // 임의로 몇 개의 로프만 골라서 사용해도 되므로,
		}											//	무조건 지금 로프보다 많이 들 수 있는 것이 더 좋음
		
		System.out.println(max);
	}

}
