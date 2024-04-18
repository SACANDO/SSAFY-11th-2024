package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ11052 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		// 인덱스는 카드 개수, 밸류값은 가격
		int[] card = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			card[i] = sc.nextInt();
		}
		
		int[] dp = new int[n+1];
		
		dp[1] = card[1];
		dp[2] = Math.max(card[1]*2, card[2]);
		
		for(int i=3; i<n+1; i++) {
			//홀수 일 때
			if(i%2==1) {
				dp[i]=Math.max(card[i], card[1]+dp[i-1]);
			}
			
			//짝수일 때
			else {
				dp[i] = Math.max(card[i], Math.max(dp[i/2] *2, dp[i-1]+card[1]));
			}
		}
//		System.out.println(Arrays.toString(card));
//		System.out.println(Arrays.toString(dp));
		
		System.out.println(dp[n]);
	}
}
