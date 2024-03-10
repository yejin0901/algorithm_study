import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2531_회전초밥 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); 
        int d = Integer.parseInt(st.nextToken()); 
        int k = Integer.parseInt(st.nextToken()); 
        int c = Integer.parseInt(st.nextToken()); 
        int arr[] = new int[N];

        for(int i = 0; i < N; i++) {
        	arr[i] = Integer.parseInt(br.readLine());
        }

        int start = 0;
        int end = start+1;
        int answer = Integer.MIN_VALUE;

        while(true){
            if(start == N) {
            	break;
            }
            
            int len = 1;
            boolean[] sushi = new boolean[d + 1];
            sushi[arr[start]] = true;

            while(true){
                if(len == k){
                    sushi[c] = true;
                    int cnt = 0;
                    for(int i = 0; i <= d; i++){
                        if(sushi[i]) {
                        	cnt++;
                        }
                    }
                    answer = Math.max(answer,cnt);
                    start++;
                    if(start == N-1) {
                    	end = 0;
                    } else {
                    	end = start+1;
                    }
                    
                    break;
                }
                
                sushi[arr[end++]] = true;
                len++;
                if(end == N){
                    end = end-N;
                }
            }
        }
        System.out.println(answer);
            
    }
}
