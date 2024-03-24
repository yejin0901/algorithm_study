import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_20922_겹치는건싫어_실버1 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int answer = 0;
		int start = 0;
		int end = 0;
		int cnt[] = new int[100001];
		while(end < arr.length) {
			while(end < arr.length && cnt[arr[end]] + 1 <= K) {
				cnt[arr[end]]++;
				end++;
			}
			int len = end - start;
			answer = Math.max(answer, len);
			cnt[arr[start]]--;
			start++;
		}
		System.out.println(answer);
	}

}
