import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14889_스타트와링크 {
	static int N;
	static int Min = Integer.MAX_VALUE;
	static boolean[] visited;
	static int[][] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		visited = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		BT(0, 0);
		
		System.out.println(Min);
	}
	
	public static void BT(int depth, int idx) {
        if(depth == N / 2) {
        	int start = 0;
        	int link = 0;
        	
        	for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					if (visited[i] && visited[j]) {
                        start += arr[i][j];
                        start += arr[j][i];
                    }
                    else if (!visited[i] && !visited[j]) {
                        link += arr[i][j];
                        link += arr[j][i];
                    }
				}
			}
        	
        	int margin = Math.abs(start - link);
        	
        	if (margin == 0) {
                System.out.println(margin);
                System.exit(0);
        	}
        	
        	 Min = Math.min(margin, Min);
             return;
        }
        
        for (int i = idx; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                BT(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }
}
