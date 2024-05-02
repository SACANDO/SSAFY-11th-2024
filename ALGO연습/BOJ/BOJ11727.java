package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ11727 {
	
	static int[] dp = new int[1001];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		dp[1] = 1;
		dp[2] = 3;
		
		
		for(int i=3; i<1001; i++) {
			dp[i] = (dp[i-2]*2 +dp[i-1]) %10007;
		}
//		System.out.println(Arrays.toString(dp));
		System.out.println(dp[n]);
	}
}
