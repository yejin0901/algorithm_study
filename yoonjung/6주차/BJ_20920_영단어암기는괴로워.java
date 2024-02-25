import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class BJ_20920_영단어암기는괴로워 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		// 우선 순위
		// 1. 자주 나오는 단어일수록 앞에 배치한다.
		// 2. 해당 단어의 길이가 길수록 앞에 배치한다.
		// 3. 알파벳 사전 순으로 앞에 있는 단어일수록 앞에 배치한다
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			if(str.length() < M) {
				continue;
			} else {
				Integer count = map.getOrDefault(str, 0);
				map.put(str, count + 1);
			}
		}
			
			List<String> word = map.keySet().stream().collect(Collectors.toList());
			word.sort((o1, o2) -> {
	            int c1 = map.get(o1);
	            int c2 = map.get(o2);

	            if(c1 == c2){ 
	                if(o1.length() == o2.length()) { 
	                    return o1.compareTo(o2); // 3. 알파벳 사전 순으로 앞에 있는 단어일수록 앞에 배치한다
	                }
	                return o2.length()-o1.length(); // 2. 해당 단어의 길이가 길수록 앞에 배치한다.
	            }
	            return c2-c1; // 1. 자주 나오는 단어일수록 앞에 배치한다.
	        });

			StringBuilder sb=new StringBuilder();
	        for(int i = 0; i < word.size(); i++){
	            sb.append(word.get(i)).append("\n");
	        }
	        System.out.println(sb);
	}

}
