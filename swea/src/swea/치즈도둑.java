package swea;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 치즈도둑 {

	static class Map {
		int r, c;

		public Map(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int cnt, max, N;
	static Queue<Map> q = new LinkedList<>(), cq = new LinkedList<>();
	// 우하좌상
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	static int[][] map;
	static boolean[][] visited;

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		for (int t = 1; t <= tc; t++) {
			N = sc.nextInt();
			max=0;
			map = new int[N][N];
			visited = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			for (int i = 0; i <= 100; i++) {
				// 카운트 초기화
				cnt = 0;
				// 해당날짜 치즈 지우기
				// visited false처리
				for (int j = 0; j < N; j++) {
					for (int q = 0; q < N; q++) {
						visited[j][q] = false;
						if (map[j][q] == i) {
							map[j][q] = 0;
						}
					}
				}

				BFS(new Map(0, 0));
				if (cnt == 0) 	break;
				if(cnt>max) max = cnt;
				
			}
			System.out.println("#" + t+ " " +max);
		}
	}

	static void BFS(Map m) {
		q.offer(m);
		visited[m.r][m.c] = true;

		while (!q.isEmpty()) {
			Map curr = q.poll();

			// 치즈면 chBFS돌기
			if (map[curr.r][curr.c] != 0) {
				chBFS(curr);
			} else {
				// 아니면 그냥 BFS돌기
				for (int i = 0; i < 4; i++) {
					int cr = curr.r + dr[i];
					int cc = curr.c + dc[i];
					if (cr < N && cr >= 0 && cc < N && cc >= 0 && !visited[cr][cc]) {
						// 치즈면 chBFS돌기
						if (map[cr][cc] != 0) {
							chBFS(new Map(cr, cc));
						} else {
							q.offer(new Map(cr, cc));
							visited[cr][cc] = true;
						}
					}
				}
			}
		}
	}

	static void chBFS(Map cm) {
		cnt++;
		
		cq.offer(cm);
		visited[cm.r][cm.c] = true;

		while (!cq.isEmpty()) {
			Map curr = cq.poll();

			for (int i = 0; i < 4; i++) {
				int cr = curr.r + dr[i];
				int cc = curr.c + dc[i];
				if (cr < N && cr >= 0 && cc < N && cc >= 0 && !visited[cr][cc]) {
					// 치즈면 치즈큐에 넣기
					if (map[cr][cc] != 0) {
						cq.offer(new Map(cr, cc));
						visited[cr][cc] = true;
					} else {
						q.offer(new Map(cr, cc));
						visited[cr][cc] = true;

					}
				}
			}
		}

	}

}
