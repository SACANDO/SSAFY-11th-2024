import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ2667 {

	static int N;
	static List<Integer> list = new ArrayList<>();
	static int[][] map;
	static boolean[][] visited;
	static Queue<int[]> queue = new LinkedList<>();
	static Queue<int[]> queue2 = new LinkedList<>();
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static int danji;


	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			String[] line = br.readLine().split("");
//			System.out.println(Arrays.toString(line));
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(line[j]);
			}
		}

		queue.offer(new int[] { 0, 0 });

		BFS();

		System.out.println(danji);
		Collections.sort(list);
		for (int l : list) {
			System.out.println(l);
		}
	}

	static void BFS() {

		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			
			if(map[curr[0]][curr[1]]==1) {
				queue2.offer(curr);
				BFS2();
			}
			
			visited[curr[0]][curr[1]] = true;

			for (int i = 0; i < 4; i++) {
				int rr = curr[0] + dr[i];
				int cc = curr[1] + dc[i];
				if (rr >= 0 && rr < N && cc >= 0 && cc < N && !visited[rr][cc]) {
					if (map[rr][cc] == 1) {
						queue2.offer(new int[] { rr, cc });
						visited[rr][cc]=true;
						BFS2();
					} else
						queue.offer(new int[] { rr, cc });
						visited[rr][cc]=true;
				}
			}

		}

	}

	static void BFS2() {
		
		int cnt = 0;
		danji++;

		while (!queue2.isEmpty()) {
			int[] curr = queue2.poll();
			
			visited[curr[0]][curr[1]] = true;
			cnt++;
//			System.out.println(Arrays.toString(curr));
			for (int i = 0; i < 4; i++) {
				int rr = curr[0] + dr[i];
				int cc = curr[1] + dc[i];
				if (rr >= 0 && rr < N && cc >= 0 && cc < N && !visited[rr][cc]) {
					if (map[rr][cc] == 1) {
						queue2.offer(new int[] { rr, cc });
						visited[rr][cc]=true;
					}
					else {
						queue.offer(new int[] { rr, cc });
						visited[rr][cc]=true;
					}
				}
			}

		}
		if (cnt != 0)
			list.add(cnt);
	}
}
