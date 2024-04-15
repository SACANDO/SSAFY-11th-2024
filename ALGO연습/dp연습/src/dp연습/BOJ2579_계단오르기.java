package dp연습;

import java.util.Scanner;

public class BOJ2579_계단오르기 {
	static int[] dp;
	static int N;
	static int[] stair;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		dp = new int[301];
		stair = new int[301];
		for (int i = 1; i <= N; i++) {
			stair[i] = sc.nextInt();
		}

		dp[1] = stair[1];
		dp[2] = stair[1] + stair[2];
		dp[3] = Math.max(stair[2] + stair[3], stair[1] + stair[3]);

		for (int i = 4; i <= N; i++) {
			// 밟
			dp[i] = Math.max(dp[i - 2] + stair[i], dp[i - 3] + stair[i - 1] + stair[i]);
		}
		System.out.println(dp[N]);

	}
}
