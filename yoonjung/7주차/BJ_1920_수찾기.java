package Binary_Search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1920_수찾기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int [N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int target = Integer.parseInt(st.nextToken());
			System.out.println(BS(arr, target, 0, N-1));
		}
		
	}
	
	public static int BS(int[] arr, int target, int start, int end) {
		while(start <= end) {
			int mid = (start + end) / 2;
			if(arr[mid] == target) {
				return 1;
			} else if(arr[mid] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return 0;
	}

}
