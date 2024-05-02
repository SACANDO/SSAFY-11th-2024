package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 보호필름 {
	static int D, W, K, ans;
	static int[][] film;
	static int[][] copy;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			String[] line = br.readLine().split(" ");
			D = Integer.parseInt(line[0]);
			W = Integer.parseInt(line[1]);
			K = Integer.parseInt(line[2]);

			film = new int[D][W];
			copy = new int[D][W];
			for (int i = 0; i < D; i++) {
				String[] line2 = br.readLine().split(" ");
				for (int j = 0; j < W; j++) {
					film[i][j] = Integer.parseInt(line2[j]);
					copy[i][j] = Integer.parseInt(line2[j]);
				}
			}
			ans = K;
			if (check(0))
				System.out.println("#" + t + " " + 0);
			else {
				comb(0, 0);
				System.out.println("#" + t + " " + ans);
			}
		}
	}

	static void comb(int idx, int cnt) {
		if (cnt >= K)
			return;
		if (idx >= D)
			return;

		comb(idx + 1, cnt);
		if (check(cnt)) {
			ans = ans > cnt + 1 ? cnt + 1 : ans;
		}

		///////////////////
		injection(idx, 0);
		if (check(cnt)) {
			ans = ans > cnt + 1 ? cnt + 1 : ans;
		}
		comb(idx + 1, cnt + 1);

		/////////////////////
		injection(idx, 1);
		if (check(cnt)) {
			ans = ans > cnt + 1 ? cnt + 1 : ans;
		}

		comb(idx + 1, cnt + 1);
		renew(idx);

//		
	}

	static void injection(int i, int num) {
		for (int j = 0; j < W; j++) {
			film[i][j] = num;
		}
	}

	static void renew(int i) {
		for (int j = 0; j < W; j++) {
			film[i][j] = copy[i][j];
		}
	}

	static boolean check(int sidx) {

		boolean flag = true;

		for (int j = 0; j < W; j++) {
			int cnt = 1;
			int medi = film[0][j];
			for (int i = 1; i < D; i++) {
				if (cnt >= K)
					break;
				if (film[i][j] == medi) {
					cnt++;
				} else {
					cnt = 1;
					medi = film[i][j];
				}
			}
			if (cnt < K)
				flag = false;
			

		}

		return flag;
	}

}
