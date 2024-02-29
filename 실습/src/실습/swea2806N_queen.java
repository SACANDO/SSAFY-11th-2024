package 실습;

import java.util.Scanner;

public class swea2806N_queen {

	static int N;
	static boolean[][] board;
	static int cnt;


	static int[] dr = { -1, 1, -1, 1 };
	static int[] dc = { -1, 1, 1, -1 };

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			cnt=0;
			N = sc.nextInt();
			board = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					board[i][j] = true;
				}
			}
			backtracking(0, 0,0);
			System.out.println(cnt);

		}

	}

	static void backtracking(int r, int c, int queen) {
		if (queen==N) {
			cnt++;
			return;
		}
		if(c>=N||r>=N) {
			return;
		}

		if (possible(r, c)) {
			backtracking(r + 1, c,queen+1);
		} else {
			backtracking(r, c + 1,queen);
		}
		
//		if ()
//			backtracking(r, c + 1,queen);

	}

	static boolean possible(int r, int c) {
		if (board[r][c]) {
			for (int i = 0; i < N; i++) {
				board[r][i] = false;
				board[i][c] = false;
			}
			
			for (int i = 0; i < 4; i++) {
				if (r + dr[i] < N && r + dr[i] >= 0 && c + dc[i] >= 0 && c + dc[i] < N) {
					board[r + dr[i]][c + dc[i]] = false;
				}
			}

			return true;
		}
		return false;

	}
}
