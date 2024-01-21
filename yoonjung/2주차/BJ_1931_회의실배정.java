package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ_1931_회의실배정 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] time = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			time[i][0] = Integer.parseInt(st.nextToken());
			time[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(time, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) { 		// 종료시간이 같을 때
					return o1[0] - o2[0];	// 시작시간이 빠른순으로 정렬
				} else {				
					return o1[1] - o2[1];
				}
	 
			}
		});
		
		int count = 0;
		int pre_end_time = 0;
		
		for(int i = 0; i < N; i++) {
			if(pre_end_time <= time[i][0]) {
				pre_end_time = time[i][1];
				count++;
			}
		}
		
		System.out.println(count);
		
	}
}
