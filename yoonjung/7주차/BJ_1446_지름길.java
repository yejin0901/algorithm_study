import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_1446_지름길 {
	static int answer, D;
	static ArrayList<int[]> list=new ArrayList<int[]>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int road = Integer.parseInt(st.nextToken());
			
			if(end > D) {
				continue; //역주행 불가
			}
			
			if(end - start <= road) {
				continue; //지름길로서의 의미가 X
			}
			
			list.add(new int[] {start, end ,road});	
		}
		
		answer = Integer.MAX_VALUE;
		func(0,0);
		System.out.println(answer);
	}
	
	static void func(int v, int cost) {
		if(cost >= answer) return;
		
		if(v == D) {
			answer = cost;
			return;
		}
		
		for(int i = 0; i < list.size(); i++) { // 지름길 이용
			int[] p = list.get(i);
			if(p[0] == v) {
				func(p[1], cost+p[2]);
			}
		}
		
		func(v + 1, cost + 1); // 그냥 이동
	}

}