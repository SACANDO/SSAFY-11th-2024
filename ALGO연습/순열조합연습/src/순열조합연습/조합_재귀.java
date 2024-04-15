package 순열조합연습;

import java.util.Arrays;

public class 조합_재귀 {
	static int cnt = 0;
	static int[] arr = { 1, 2, 3, 4, 5 };
	static int[] chosen = new int[3];
	static int n = 3;

	public static void main(String[] args) {
		combination(0, 0);
		System.out.println(cnt);
	}

	// 재귀는 방문체크를 안해도 됨 -> 어차피 쓴 수는 안 볼 거기 때문에

	static void combination(int idx, int sidx) {

		// 갯수 제어
		if (sidx >= n) {
			System.out.println(Arrays.toString(chosen));
			cnt++;
			return;
		}

		for (int i = idx; i <= 5 - 3 + sidx; i++) {
			chosen[sidx] = arr[i];
			combination(i + 1, sidx + 1);
		}
	}
}
