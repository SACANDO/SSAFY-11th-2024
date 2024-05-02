package dp연습;

import java.util.Scanner;

public class BOJ14916 {
	static int[] dp;
	static int money;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		money = sc.nextInt();
		dp = new int[100001];
		
		dp[2]=1;
		dp[4]=2;
		dp[5]=1;
		dp[6]=3;
		dp[7]=2;
		dp[8]=4;
		
		
		if(money==1 || money==3) System.out.println(-1);
		else System.out.println(dynamic(money));
		
	}
	
	static int dynamic(int idx) {
		
		
		if(idx<=5) {
			return dp[idx];
		}
		if(dp[idx]==0) {
			dp[idx]=Math.min(dynamic(idx-2)+1,dynamic(idx-5)+1);
		}
		
		return dp[idx];
	}
	
}
