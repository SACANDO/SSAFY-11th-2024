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
			ans=13;
			if (check(0))
				System.out.println("#"+t+" " + 0);
			else {
				comb(0, 0);
				System.out.println("#" + t + " " + ans);
			}
		}
	}

	static void comb(int idx, int sidx) {
		if (sidx >= K)
			return;
		for (int i = idx; i <= D - K + sidx; i++) {
			
			//0으로 바꾸고
			zero(i);
			//체크
			if (check(sidx)) {
//				System.out.println("--------"+sidx);
				ans = ans>sidx + 1?sidx+1 : ans;
				renew(i);
//				System.out.println(ans);
				return;
			}
			//안됐으면 보내기
			comb(idx + 1, sidx + 1);
			
			//이젠 1로 바꾸고
			one(i);
			//체크
			if (check(sidx)) {
//				System.out.println("--------"+sidx);
				ans = ans> sidx + 1? sidx+1 :ans;
				renew(i);
//				System.out.println(ans);
				return;
			}
			//안됐으면 보내기
			comb(idx + 1, sidx + 1);
			
			//다시 돌려놓기
			renew(i);

		}
	}
	
	static void zero(int i) {
		for (int j = 0; j < W; j++) {
			film[i][j] = 0;
		}
	}
	static void one(int i) {
		for (int j = 0; j < W; j++) {
			film[i][j] = 1;
		}
	}
	static void renew(int i) {
		for (int j = 0; j < W; j++) {
			film[i][j] = copy[i][j];
		}
	}

	static boolean check(int sidx) {
		if(sidx==1) System.out.println("-----"+sidx);
		boolean flag = true;

		for (int j = 0; j < W; j++) {
			int cnt = 1;
			int medi = film[0][j];
			for (int i = 1; i < D; i++) {
				if (cnt >= K)
					continue;
				if (film[i][j] == medi) {
					cnt++;
				} else {
					cnt = 1;
					medi = film[i][j];
				}
			}
			if (cnt < K)
				flag = false;
			if(sidx==1)System.out.println(cnt);
		}
//		System.out.println(flag);
		if(flag&& sidx==1) {
			for(int[] ii : film) {
				System.out.println(Arrays.toString(ii));
			}
		}
		return flag;
	}

}
