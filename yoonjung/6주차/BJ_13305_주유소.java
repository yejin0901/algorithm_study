import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_13305_주유소 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		long[] road = new long[N-1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N-1; i++) {
			road[i] = Long.parseLong(st.nextToken());
		}
		
		long[] city = new long[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			city[i] = Long.parseLong(st.nextToken());
		}
		
		long sum = 0;
		long min = city[0];
		
		for (int i = 0; i < N - 1; i++) {
			if(city[i] < min) {
				min = city[i];
			}
			sum += (min * road[i]);
		}
		
		System.out.println(sum);
	}

}
