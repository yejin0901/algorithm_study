package Simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1018_체스판다시칠하기 {
	static int[][] arr;
	public static int answer = 64;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String str =br.readLine();
			for (int j = 0; j < M; j++) {
				if(str.charAt(j) == 'W') {
					arr[i][j] = 0;
				} else {
					arr[i][j] = 1;
				}
			}
		}
		
		int row = N - 7;
		int col = M - 7;
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				BT(i, j);
			}
		}
		System.out.println(answer);
	}
	
	public static void BT(int x, int y) {
		int last_x = x + 8;
		int last_y = y + 8;
		int count = 0;
		
		int color = arr[x][y];
		
		for (int i = x; i < last_x; i++) {
			for (int j = y; j < last_y; j++) {
				if(arr[i][j] != color) {
					count++;
				}
				
				if(color == 1) {
					color = 0;
				} else {
					color = 1;
				}
			}
			
			if(color == 1) {
				color = 0;
			} else {
				color = 1;
			}
		}
		count = Math.min(count, 64 - count);
		answer = Math.min(answer, count);
	}

}
