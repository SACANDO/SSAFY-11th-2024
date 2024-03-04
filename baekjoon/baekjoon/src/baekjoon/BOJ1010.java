package baekjoon;

import java.util.Scanner;

public class BOJ1010 {
	static int cnt=0;
	static int m,n;
	static boolean[] fArr;
	static int[][] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		for(int t=1; t<=tc; t++) {
			n=sc.nextInt();
			m= sc.nextInt();  
			fArr = new boolean[m];
			dp = new int[m][n];
			bridge(0,0);
			System.out.println(cnt);
		}
	}
	static int bridge(int idx, int east) {
		if(east==n) {
			cnt++;
			return 1;
		}
		if(idx>m) {
			return 1;
		}
		
		for(int i=idx;i<m; i++) {
			fArr[i]=true;
			if(dp[i+1][east+1]!=0) {
				return dp[i+1][east+1];
			} else {
				dp[i+1][east+1]=bridge(i+1,east+1);
			}
			fArr[i]=false;
			if(dp[i+1][east]!=0) {
				return dp[i+1][east];
			} else {
				dp[i+1][east]=bridge(i+1,east);
			}
		}
		return 0;
	}
}
