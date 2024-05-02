package dfs연습;

import java.util.Scanner;
import java.util.Stack;

public class BOJ1520 {

	static int[][] map;
	static int[][] cnt; 
	static int r,c;
	static int[] dr= {1,-1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();
		
		map = new int[r][c];
		cnt = new int[r][c];
		
		for(int i=0; i<r;i++) {
			for(int j=0; j<c; j++) {
				map[i][j]=sc.nextInt();
			}
		}
		DFS(0,0);

		System.out.println(cnt[r-1][c-1]);
		
		
		
	}

	
	static void DFS(int infor, int infoc) {
		
		cnt[infor][infoc]++;
		for(int i=0; i<4; i++) {
			int rr= infor+dr[i];
			int cc= infoc+dc[i];
			if(rr>=0&&cc>=0&&rr<r&&cc<c&&map[rr][cc]<map[infor][infoc]) {
				DFS(rr,cc);
			}
		}
	}
}
