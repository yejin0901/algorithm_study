import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14888_연산자끼워넣기 {
	static int N;
	static int Max = Integer.MIN_VALUE;
	static int Min = Integer.MAX_VALUE;
	static int[] arr;
	static int[] calc = new int[4];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			calc[i] = Integer.parseInt(st.nextToken());
		}
		
		BT(arr[0], 1);
		
		System.out.println(Max);
		System.out.println(Min);
		
	}
	
	public static void BT(int num, int idx) {
		if(idx == N) {
			Max = Math.max(Max, num);
			Min = Math.min(Min, num);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			if(calc[i] > 0) {
				calc[i]--;
				
				switch (i) {
				case 0: BT(num + arr[idx], idx + 1);
					break;
				case 1: BT(num - arr[idx], idx + 1);
					break;
				case 2: BT(num * arr[idx], idx + 1);
					break;
				case 3: BT(num / arr[idx], idx + 1);
					break;
				}
				
				calc[i]++;
			}
		}
	}

}
