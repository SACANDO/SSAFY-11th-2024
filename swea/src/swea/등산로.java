package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 등산로 {
	static class Info {
		int r, c, len;

		public Info(int r, int c, int len) {
			this.r = r;
			this.c = c;
			this.len = len;

		}

	}

	static int N, K, max, top;
	static int[][] map;
	static List<Info> list;
	static Queue<Info> queue = new LinkedList<>();

	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			String[] line = br.readLine().split(" ");
			N = Integer.parseInt(line[0]);
			K = Integer.parseInt(line[1]);
			map = new int[N][N];
			max = 1;
			list = new LinkedList<>();
			for (int i = 0; i < N; i++) {
				String[] line2 = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(line2[j]);

				}
			}

			// 일단 확인
			findAndSetTop();
			makeRoad();

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int tmp = map[i][j];
					for (int q = 1; q <= K; q++) {
//						if (map[i][j] == 0) {
//							map[i][j] = tmp;
//							break;
//						}
						map[i][j]--;
						
						for(int k=0; k<list.size(); k++) {
							queue.offer(list.get(k));
						}
						makeRoad();
						
					}
					map[i][j] = tmp;
				}
			}

			System.out.println("#"+t+" " +max);
		}
	}

	static void makeRoad() {

		while (!queue.isEmpty()) {
			Info curr = queue.poll();
			boolean flag = false;

			for (int i = 0; i < 4; i++) {
				int rr = curr.r + dr[i];
				int cc = curr.c + dc[i];

				if (!isInBoundary(rr, cc))
					continue;
				if (map[rr][cc] < map[curr.r][curr.c]) {
					queue.offer(new Info(rr, cc, curr.len + 1));
					flag = true;
				}

			}
			if (!flag) {
				if (curr.len > max) {
					max = curr.len;

				}
			}
		}
		
	}

	static boolean isInBoundary(int br, int bc) {
		return br >= 0 && br < N && bc >= 0 && bc < N;
	}

	static void findAndSetTop() {
		top = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] > top) {
					top = map[i][j];
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == top) {
					list.add(new Info(i, j, 1));
				}
			}
		}
	}

}
