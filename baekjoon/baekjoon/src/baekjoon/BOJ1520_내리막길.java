package baekjoon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BOJ1520_내리막길 {

	static int[][] map;
	static int[][] cnt;
	static boolean[][] isChecked;
	static boolean[][] isVisited;
	static int r, c;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();

		map = new int[r][c];
		cnt = new int[r][c];
		isChecked = new boolean[r][c];
		isVisited = new boolean[r][c];
		cnt[0][0] = 1;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		DFS(0, 0);
		for (boolean[] a : isChecked) {
			System.out.println(Arrays.toString(a));
		}

		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { 0, 0 });

		// BFS
		while (!queue.isEmpty()) {
			
			int[] curr = queue.poll();
//			System.out.println(Arrays.toString(curr));
			int i = curr[0];
			int j = curr[1];
			isVisited[i][j]=true;
			
			for (int q = 0; q < 4; q++) {
				int rr = i + dr[q];
				int cc = j + dc[q];
				if (rr >= 0 && cc >= 0 && rr < r && cc < c && isChecked[rr][cc]) {
					if (map[rr][cc] > map[i][j])
						if(cnt[rr][cc]==0) {
							queue.offer(new int[] {rr,cc});
						}else {
							cnr[i][j]
						}
					if(!isVisited[rr][cc]) {
						queue.offer(new int[] { rr, cc });
						isVisited[rr][cc]=true;
					}
					

				}
			}
		}
		for(int[] c : cnt) {
			System.out.println(Arrays.toString(c));
		}
		System.out.println(cnt[r - 1][c - 1]);

	}

	static void DFS(int infor, int infoc) {

		isChecked[infor][infoc] = true;
//			if(infor==r-1&&infoc==c-1) return true;
		for (int i = 0; i < 4; i++) {
			int rr = infor + dr[i];
			int cc = infoc + dc[i];
			if (rr >= 0 && cc >= 0 && rr < r && cc < c && map[rr][cc] < map[infor][infoc] && !isChecked[rr][cc]) {
				DFS(rr, cc);
			}
		}
//			return false;

	}

	static void dp() {

	}
}
