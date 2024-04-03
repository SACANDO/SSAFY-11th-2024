import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BOJ2206 {
	static class Info implements Comparable<Info> {
		int r, c, w, hammer;

		public Info(int r, int c, int w, int h) {
			this.r = r;
			this.c = c;
			this.w = w;
			this.hammer = h;
		}

		@Override
		public String toString() {
			return "Info [r=" + r + ", c=" + c + ", w=" + w + ", hammer=" + hammer + "]";
		}

		@Override
		public int compareTo(Info o) {
			return this.w - o.w;
		}

	}

	static int R, C;
	static int min = 987654321;
	static int[][] map;
	static boolean[][][] visited;
	static PriorityQueue<Info> pq = new PriorityQueue<>();
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		R = Integer.parseInt(line[0]);
		C = Integer.parseInt(line[1]);

		map = new int[R][C];
		visited = new boolean[R][C][2];
		// 0은 아직 벽부술 수 있는 애
		// 1은 벽 이미 부순 애
		for (int i = 0; i < R; i++) {
			String[] line2 = br.readLine().split("");
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(line2[j]);

			}
		}

		pq.offer(new Info(0, 0, 1, 0));
		visited[0][0][0] = true;

		while (!pq.isEmpty()) {

			Info curr = pq.poll();
			visited[curr.r][curr.c][curr.hammer] = true;
			if (curr.r == R - 1 && curr.c == C - 1) {
				if (curr.w < min) {
					min = curr.w;
					break;
				}
			}

//			System.out.println(curr);
			for (int i = 0; i < 4; i++) {
				int rr = curr.r + dr[i];
				int cc = curr.c + dc[i];

				if (rr < R && rr >= 0 && cc >= 0 && cc < C&&!visited[rr][cc][curr.hammer]) {
					if (map[rr][cc] == 0) {
						pq.offer(new Info(rr, cc, curr.w + 1, curr.hammer));
						visited[rr][cc][curr.hammer] = true;
					} else {
						if (curr.hammer == 0) {
							pq.offer(new Info(rr, cc, curr.w + 1, 1));
							visited[rr][cc][1] = true;
						}
					}
				}
			}

		}

		if (min == 987654321)
			System.out.println(-1);
		else
			System.out.println(min);

	}
}
