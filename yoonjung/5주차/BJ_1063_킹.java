package Simulation;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1063_킹 {
	static int[][] arr = new int[9][9];
	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] djy = {0, 1, 1, 1, 0, -1, -1, -1};
	static int Kx, Ky ;
	static int Sx, Sy;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST = new StringTokenizer(br.readLine());
			
		String king = ST.nextToken();
		Kx = king.charAt(1)-'0';
		Ky = king.charAt(0)-'A'+1;
			
		String stone = ST.nextToken();
		Sx = stone.charAt(1)-'0';
		Sy = stone.charAt(0)-'A'+1;
		
		int N = Integer.parseInt(ST.nextToken());
		
		int dx = 0;
		int dy = 0;
		for(int i = 0; i < N; i++) {
			String type = br.readLine();
		
			if(type.equals("T")) {
				dx = 1;
				dy = 0;
			} else if(type.equals("RT")) {
				dx = 1;
				dy = 1;
			} else if(type.equals("R")) {
				dx = 0;
				dy = 1;
			} else if(type.equals("RB")) {
				dx = -1;
				dy = 1;
			} else if(type.equals("B")) {
				dx = -1;
				dy = 0;
			} else if(type.equals("LB")) {
				dx = -1;
				dy = -1;
			} else if(type.equals("L")) {
				dx = 0;
				dy = -1;
			} else if(type.equals("LT")) {
				dx = 1;
				dy = -1;
			}
				
			move(dx, dy);
		}
		char king_y = (char) (Ky + 'A' -1);
		char stone_y = (char) (Sy + 'A' -1);
			
		System.out.println(king_y + "" + Kx);
		System.out.println(stone_y + "" + Sx);
	}
	
	static boolean check(int x, int y) {
		if(1 <= x && x <=8 && 1 <= y && y <= 8) {
			return true;
		}
		return false;
	}
	
	static void move(int dx, int dy) {
		
		int k_nx = Kx+dx;
		int k_ny = Ky+dy;
		
		if(check(k_nx, k_ny)) {
			if(k_nx == Sx && k_ny == Sy) {
				if(check(Sx + dx, Sy + dy)) {
					Sx += dx;
					Sy += dy;
					Kx = k_nx;
					Ky = k_ny;
				}
			} else {
				Kx = k_nx;
				Ky = k_ny;
			}
		}
	}
}
