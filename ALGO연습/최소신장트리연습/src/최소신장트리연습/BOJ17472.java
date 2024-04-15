package 최소신장트리연습;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ17472 {
	static class Edge {
		int A, B, W;

		public Edge(int a, int b, int w) {
			A = a;
			B = b;
			W = w;
		}
		
	}

	static int r, c;
	static int[][] map;
	static Queue<int[]> queue = new LinkedList<>();
	static Queue<int[]> island = new LinkedList<>();
	static boolean[][] visited;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static int num;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		r = sc.nextInt();
		c = sc.nextInt();
		map = new int[r + 2][c + 2];
		visited = new boolean[r + 2][c + 2];
		for (int i = 0; i < r + 2; i++) {
			for (int j = 0; j < c + 2; j++) {
				if (i == 0 || i == r + 1 || j == 0 || j == c + 1) {
					map[i][j] = 0;
					visited[i][j] = true;
					continue;
				}
				map[i][j] = sc.nextInt();
			}
		}
		queue.offer(new int[] { 1, 1 });
		BFS();
		
		for(int[] i : map) {
			System.out.println(Arrays.toString(i));
		}
	}

	static void BFS() {
		// while 문 안에 while 문 만들기
		while (!queue.isEmpty()) {
			int[] c = queue.poll();
			System.out.println(Arrays.toString(c));
			int br = c[0];
			int bc = c[1];
			visited[br][bc] = true;

			if (map[br][bc] == 1) {
				island.offer(new int[] { br, bc });
				num++;
				while (!island.isEmpty()) {
					int[] is = island.poll();
					visited[is[0]][is[1]] = true;
					map[is[0]][is[1]] = num;
					for (int i = 0; i < 4; i++) {
						int ir = is[0] + dr[i];
						int ic = is[1] + dc[i];
						if (!visited[ir][ic]) {
							if (map[ir][ic] == 1) {
								island.offer(new int[] { ir, ic });
								visited[ir][ic] = true;
							} else {
								queue.offer(new int[] { ir, ic });
								visited[ir][ic] = true;
							}
						}
					}
				}
			} else {
				for (int i = 0; i < 4; i++) {
					if (!visited[br + dr[i]][bc + dc[i]]) {
						queue.offer(new int[] { br + dr[i], bc + dc[i] });
						visited[br + dr[i]][bc + dc[i]] = true;
					}
				}
			}
		}

	}
}