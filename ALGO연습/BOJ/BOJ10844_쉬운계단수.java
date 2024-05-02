package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ10844_쉬운계단수 {
	static long[][] dp = new long[101][10];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		//1번째 자리수는 미리 초기화
		for(int i=1; i<10; i++) {
			dp[1][i] = 1;
		}
		
		// 그 다음부터
		
		for(int i=2; i<101; i++) {
			for(int j=0; j<10; j++) {
				if(j==0) dp[i][j]=(dp[i-1][1])%1000000000;
				else if(j==9) dp[i][j]=dp[i-1][8]%1000000000;
				else dp[i][j] = dp[i-1][j-1]%1000000000 + dp[i-1][j+1]%1000000000;
				
			}
		}
		
		long ans = 0;
		for(int i=0; i<10; i++) {
			ans+=dp[n][i];
		}
		
		System.out.println(ans%1000000000);
		
		

	}
}
