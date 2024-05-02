package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class 탈주범검거 {
	static int N, M, R, C, L;
	static int[][] map;
	static boolean[][] visited;

	// 상하좌우 순서
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[] idx = { 1, -1, 1, -1 };

	// 상하좌우로 터널 정보 만들기
	static Map<Integer, boolean[]> tInfo = new HashMap<>();
	static Queue<Info> queue;

	static class Info {
		int r, c;

		public Info(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Info [r=" + r + ", c=" + c + "]";
		}
	}

	// 도착후 1시간이 지나면 맨홀 뚜껑이 위치한 곳에 있음
	// 뚜껑 위치queue에 삽입
	// 상하좌우를 탐색하는데 curr의 상하좌우중 true인 곳만 탐색,
	// 탐색했을 때 같은 인덱스가 true인 곳만 cnt++, queue에 삽입
	// queue 사이즈를 재서 사이즈만큼만 L번 돌고 끝
	public static void main(String[] args) throws NumberFormatException, IOException {
		tInfo.put(1, new boolean[] { true, true, true, true });
		tInfo.put(2, new boolean[] { true, true, false, false });
		tInfo.put(3, new boolean[] { false, false, true, true });
		tInfo.put(4, new boolean[] { true, false, false, true });
		tInfo.put(5, new boolean[] { false, true, false, true });
		tInfo.put(6, new boolean[] { false, true, true, false });
		tInfo.put(7, new boolean[] { true, false, true, false });


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			String[] line = br.readLine().split(" ");
			N = Integer.parseInt(line[0]);
			M = Integer.parseInt(line[1]);
			R = Integer.parseInt(line[2]);
			C = Integer.parseInt(line[3]);
			L = Integer.parseInt(line[4]);
			map = new int[N][M];
			visited = new boolean[N][M];
			queue = new LinkedList<>();
			for (int i = 0; i < N; i++) {
				String[] line2 = br.readLine().split(" ");
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(line2[j]);
				}
			}
			System.out.println("#"+t+" " + BFS());

		}

	}

	static int BFS() {

		int cnt = 1;
		queue.offer(new Info(R, C));
		visited[R][C] = true;

		for (int i = 1; i < L; i++) {
			int cmp = queue.size();
			for (int j = 0; j < cmp; j++) {
				Info curr = queue.poll();
				visited[curr.r][curr.c] = true;

				for (int q = 0; q < 4; q++) {
					if (!((tInfo.get(map[curr.r][curr.c]))[q]))
						continue;

					int rr = curr.r + dr[q];
					int cc = curr.c + dc[q];
					if (isInBoundary(rr, cc)) {
						if (visited[rr][cc])
							continue;
						if (map[rr][cc] == 0)
							continue;

						if (tInfo.get(map[rr][cc])[q + idx[q]]) {
							queue.offer(new Info(rr, cc));
							visited[rr][cc] = true;
							cnt++;
						}
					}
				}

			}
		}

		return cnt;
	}

	static boolean isInBoundary(int br, int bc) {
		return br < N && br >= 0 && bc < M && bc >= 0;
	}
}
