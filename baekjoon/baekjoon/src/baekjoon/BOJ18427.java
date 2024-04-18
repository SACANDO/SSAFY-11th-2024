package baekjoon;

import java.util.Arrays;

public class BOJ18427 {
	static int[] dp = new int[101];
	public static void main(String[] args) {
		dp[1] = 9;
		dp[2] = 17;
		dp[3] = 32;
		
		for(int i=3; i<100; i++) {
			dp[i] = ((dp[i-1]-2)*2 +2)%1000000000;
		}
		System.out.println(Arrays.toString(dp));
		
	}
}
