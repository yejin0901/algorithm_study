import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_13335_트럭 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 다리를 건너는 트럭의 수
		int w = Integer.parseInt(st.nextToken()); // 다리의 길이
		int L = Integer.parseInt(st.nextToken()); // 다리의 최대하중
		
		Queue<Integer> truck = new LinkedList<>();
		Queue<Integer> bridge = new LinkedList<>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			truck.offer(Integer.parseInt(st.nextToken()));
		}
		
		for (int i = 0; i < w; i++) {
			bridge.add(0);
		}
		
		int count = 0;
		int weight = 0;
		
		while(!bridge.isEmpty()) { // 다리 위에 아무 것도 없을 때 까지
			count++;
			weight -= bridge.poll();
			
			if(!truck.isEmpty()) {
				if(truck.peek() + weight <= L) { // 다리의 최대하중보다 작으면
					weight += truck.peek();
					bridge.offer(truck.poll());
				} else {
					bridge.offer(0);
				}
			}
		}
		
		System.out.println(count);
		
	}

}
