package Backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1182_부분수열의합 {
	static int[] arr;
	static int N, S;
	static int answer = 0;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		BT(0, 0);
		if (S == 0) { // 공집합인 경우는 제외해야 함
            answer = answer - 1;
        }
		System.out.println(answer);
	}
	
	public static void BT(int depth, int sum) {
		if(depth == N) {
			if(sum == S) {
				answer++;
			}
			return;
		}
			
			BT(depth + 1, sum + arr[depth]); // 현재 원소를 선택했을 경우
			BT(depth + 1, sum);				 // 현재 원소를 선택하지 않았을 경우
	}
}
