import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class BOJ2178 {
	static class Info {
		int r, c, w;

		public Info(int r, int c, int w) {
			this.r = r;
			this.c = c;
			this.w = w;
		}

		@Override
		public String toString() {
			return "Info [r=" + r + ", c=" + c + ", w=" + w + "]";
		}


	}

	static int R, C;
	static int min = 987654321;
	static int[][] map;
	static boolean[][] visited;
	static Queue<Info> queue = new LinkedList<>();
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		R = Integer.parseInt(line[0]);
		C = Integer.parseInt(line[1]);


		map = new int[R][C];
		visited = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			String[] line2 = br.readLine().split("");
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(line2[j]);

			}
		}

		queue.offer(new Info(0, 0, 1));

		while (!queue.isEmpty()) {

			Info curr = queue.poll();

			visited[curr.r][curr.c] = true;
//			System.out.println(curr);
			if (curr.r == R-1 && curr.c == C-1) {
				if (curr.w < min) {
					min = curr.w;
					continue;
				}
			}

			for (int i = 0; i < 4; i++) {
				int rr = curr.r + dr[i];
				int cc = curr.c + dc[i];
				if (rr<R&&rr>=0&&cc>=0&&cc<C&&map[rr][cc] == 1 && !visited[rr][cc]) {
					queue.offer(new Info(rr, cc, curr.w + 1));
					visited[rr][cc] = true;
				}
			}

		}

		System.out.println(min);

	}
}
