import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1987 {
	static int max = 0;
	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int R;
	static int C;
	//알파벳 저장
	static char[][] map;
	//방문 여부 저장
	static boolean[][] visited;
	static boolean[] alpha=new boolean[26];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");

		R = Integer.parseInt(line[0]);
		C = Integer.parseInt(line[1]);
		System.out.println(Arrays.toString(line));
		System.out.println(R + " " + C);

		map = new char[R][C];

		visited = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}

		dfs(0, 0, 1);

		System.out.println(max);
	}

	static void dfs(int r, int c, int cnt) {
		System.out.println(r + " " + c + " " + cnt + " " + map[r][c]);
		visited[r][c] = true;
		alpha[map[r][c]-'A'] =true;
		
		if (cnt >= R * C) {
			if (cnt > max) {
				max = cnt;
			}

			return;
		}
		
		boolean willvisit = false;
		for (int i = 0; i < 4; i++) {
			if (r + dr[i] < R && r + dr[i] >= 0 && c + dc[i] >= 0 && c + dc[i] < C
					&& !visited[r + dr[i]][c + dc[i]] && !alpha[map[r+dr[i]][c+dc[i]]-'A']){
				
				dfs(r + dr[i], c + dc[i], cnt + 1);

				willvisit = true;

			}
		}
		if (!willvisit) {
			if (cnt > max) {
				max = cnt;
			}
			return;

		}

	}
}