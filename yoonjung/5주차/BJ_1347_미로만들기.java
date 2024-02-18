package Simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_1347_미로만들기 {
    static char[][] arr;
    static char[] move;
    static int dx[] = {0, -1, 0, 1, 0};
    static int dy[] = {0, 0, 1, 0, -1};
    static int dir = 3;
    static int n;
    static int left_x, left_y, right_x, right_y;
    
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
        arr = new char[101][101];
        left_x = left_y = right_x = right_y = 50;
        
        move = new char[n];
        for(int i = 0; i < 101; i++) {
            for(int j = 0; j < 101; j++) {
                arr[i][j] = '#';
            }
        }
        
        String str = br.readLine();
        for(int i = 0; i < n; i++) {
            move[i] =str.charAt(i);
        }
        
        arr[50][50] = '.';
        
        int tmp_x = 50;
        int tmp_y = 50;
        for(int i = 0; i < n; i++) {
            char order = move[i];
            if(order !='F') {
                swap(order);
            } else {
                tmp_x += dx[dir];
                tmp_y += dy[dir];
                arr[tmp_x][tmp_y] ='.';
            }
        }
        
        for(int i = 0; i < 101; i++) {
            for(int j = 0; j < 101; j++) {
                if(arr[i][j] == '.') {
                    if(left_x > i) {
                        left_x = i;
                    }
                    if(left_y > j) {
                        left_y =j;
                    }
                    if(right_x <i) {
                        right_x =i;
                    }
                    if(right_y <j) {
                        right_y=j;
                    }
                }
            }
        }
        
        for(int i= left_x; i<= right_x; i++) {
            for(int j=left_y; j<= right_y; j++) {
                System.out.print(arr[i][j]+"");
            }
            System.out.println();

        }
	}
        
	public static void swap(char order) {
		if(order == 'R') {
			dir += 1;
            if(dir == 5) {
            	dir = 1;
            }
        } else {
        	dir -= 1;
            if(dir == 0) {
            	dir=4;
            }
        }
    }

}
