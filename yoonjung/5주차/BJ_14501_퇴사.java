package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14501_퇴사 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] T = new int[N]; // 기간
		int[] P = new int[N]; // 금액
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());	
		}
		
		int[] DP = new int[N + 1];
		
		for(int i = 0; i < N; i++) {
			 if(i + T[i] <= N) {	// 범위 안
				 DP[i + T[i]] = Math.max(DP[i + T[i]], DP[i] + P[i]);	
			 }
			 DP[i + 1] = Math.max(DP[i + 1], DP[i]);	// 다음 DP = 현재 누적값 vs 다음 누적값
			 
		}
		System.out.println(DP[N]);	

	}

}
