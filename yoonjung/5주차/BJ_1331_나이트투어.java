package Simulation;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ_1331_나이트투어 {
	static int pre_x, pre_y;
	static int nx, ny;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> visit = new ArrayList<String>(); // 방문한 좌표를 저장하기 위한 리스트
        
        String str1 = br.readLine();
        int start_x = str1.charAt(0); 
        int start_y = str1.charAt(1);
        pre_x = start_x;
        pre_y = start_y;
 
        visit.add(str1);
        
        for(int i = 0; i < 35; i++) {
            String str2 = br.readLine();
            nx = str2.charAt(0);
            ny = str2.charAt(1);
            
            if(visit.contains(str2)) {    // 방문한 적 있는 곳에 또 다시 방문하면 Invalid
                System.out.println("Invalid");
                return;
            }
            
            if(Math.abs(nx - pre_x) == 2 && Math.abs(ny - pre_y) == 1 || Math.abs(nx - pre_x) == 1 && Math.abs(ny - pre_y) == 2) {
            	// 나이트가 이전 위치에서 이동할 수 있는 위치가 아니면 Invalid 
            } else {
                System.out.println("Invalid");
                return;
            }
            
            visit.add(str2);
            
            pre_x = nx;
            pre_y = ny;
        }
        
        if(Math.abs(nx - start_x) == 2 && Math.abs(ny - start_y) == 1 || Math.abs(nx - start_x) == 1 && Math.abs(ny - start_y) == 2) {
        	// 마지막 도달위치에서 첫 번째 위치로 갈 수 없으면 Invalid
        } else {
            System.out.println("Invalid");
            return;
        }
        
        System.out.println("Valid");
    }

}
