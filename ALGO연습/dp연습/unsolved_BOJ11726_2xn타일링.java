package dp연습;

import java.util.Arrays;
import java.util.Scanner;

public class unsolved_BOJ11726_2xn타일링 {
	static long[] dp;
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		dp = new long[1001];
		
		dp[1]=1;
		dp[2]=2;
		
		for(int i=3; i<=N; i++) {
			dp[i] = (dp[i-1] + dp[i-2])%10007;
		}
		System.out.println(Arrays.toString(dp));
		System.out.println(dp[N]);
	}
}
