package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2630_0 {

	static int[][] paper;
	static int[] color;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		paper = new int[N][N];

		color = new int[2];

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				paper[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		cutPaper(0,0,N);
		System.out.printf("%d\n%d",color[0],color[1]);

	}

	static boolean checkPaper(int r, int c, int len) {
		int num = paper[r][c];

		for (int i = r; i < r + len; i++) {
			for (int j = c; j < c + len; j++) {
				if (paper[i][j] != num)
					return false;
			}
		}

		return true;
	}

	static void cutPaper(int r, int c, int N) {
		if (checkPaper(r, c, N))
			color[paper[r][c]]++;
		else {
			int len = N / 2;

			cutPaper(r, c, len);
			cutPaper(r + len, c, len);
			cutPaper(r, c + len, len);
			cutPaper(r + len, c + len, len);
		}
	}

}
