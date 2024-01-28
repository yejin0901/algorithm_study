package Backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_15666_N과M_12 {
	static int[] arr, arr2;
	static int N, M;
	static LinkedList<Integer> linkedList;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		arr2 = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		linkedList = new LinkedList<>();
		
		int before = arr[0];					// BT 함수에 들어가기 전에 중복 제거
		linkedList.add(arr[0]);
		for (int i = 1; i < arr.length; i++) {
			if(before != arr[i]) {
				before = arr[i];
				linkedList.add(arr[i]);
			} else {
				continue;
			}
		}
		
		BT(0, 0);
	}
	
	public static void BT(int start, int depth) {
		if(depth == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(arr2[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = start; i < linkedList.size(); i++) {
			arr2[depth] = linkedList.get(i);
			BT(i, depth + 1);
		}
	}
	
}

// (4), (8)과 같은 경우
