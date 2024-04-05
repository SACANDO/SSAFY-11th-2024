package dp연습;

import java.util.Scanner;

public class BOJ1463_1로만들기 {
	
	static int[] dp;
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		dp=new int[1000001];
		dp[2]=1;
		dp[3]=1;
		dp[4]=2;
		dp[5]=3;
		for(int i=6; i<=N; i++) {
			int a=1000000;
			int b=1000000;
			int c=dp[i-1]+1;
			if(i%3==0) a=dp[i/3]+1;
			if(i%2==0) b=dp[i/2]+1;
			
			dp[i]=Math.min(a, Math.min(b, c));
		}
		System.out.println(dp[N]);
	}
}
