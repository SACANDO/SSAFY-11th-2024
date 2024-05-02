import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ1600 {
	static class Info implements Comparable<Info> {
		int r, c, cnt, kcnt;

		public Info(int r, int c, int cnt, int kcnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.kcnt = kcnt;
		}

		@Override
		public String toString() {
			return "Info [r=" + r + ", c=" + c + ", cnt=" + cnt + ", kcnt=" + kcnt + "]";
		}

		@Override
		public int compareTo(Info o) {
			return this.cnt - o.cnt;
		}
	}

	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	static int[] hor = { -2, -2, -1, -1, 1, 1, 2, 2 };
	static int[] hoc = { -1, 1, -2, 2, -2, 2, -1, 1 };

	static int k, R, C;
	static int min = Integer.MAX_VALUE;
	static PriorityQueue<Info> pq = new PriorityQueue<>();

	static int[][] map;
	static boolean[][][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		k = sc.nextInt();
		C = sc.nextInt();
		R = sc.nextInt();
		map = new int[R][C];
		visited = new boolean[R][C][k + 1];

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		pq.offer(new Info(0, 0, 0, 0));
		BFS();

		if (min == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min);

	}

	static void BFS() {

		while (!pq.isEmpty()) {
			Info in = pq.poll();

			visited[in.r][in.c][in.kcnt] = true;

//			System.out.println(in);
			if (in.r == R - 1 && in.c == C - 1) {
				min = min > in.cnt ? in.cnt : min;
				break;
			}
			if(in.cnt>=R*C-1) continue;

			if (in.kcnt < k) {
				for (int i = 0; i < 8; i++) {
					int rr = hor[i] + in.r;
					int cc = hoc[i] + in.c;
					if (!isInboundary(rr, cc))
						continue;
					if (map[rr][cc] == 0 && !visited[rr][cc][in.kcnt + 1]) {
						pq.offer(new Info(rr, cc, in.cnt + 1, in.kcnt + 1));
						visited[rr][cc][in.kcnt + 1] = true;
					}
				}
			}

				for (int i = 0; i < 4; i++) {
					int rr = dr[i] + in.r;
					int cc = dc[i] + in.c;
					if (!isInboundary(rr, cc))
						continue;
					if (map[rr][cc] == 0 && !visited[rr][cc][in.kcnt]) {
						pq.offer(new Info(rr, cc, in.cnt + 1, in.kcnt));
						visited[rr][cc][in.kcnt] = true;

					}
				}
			}
		}
	

	static boolean isInboundary(int x, int y) {
		return x < R && x >= 0 && y < C && y >= 0;
	}
}
