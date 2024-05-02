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
		
		for(int i=idx;i<m-n+east; i++) {
			for(int j=1;j<n; j++) {
				bridge(i+j,east+j);
			}
			
		}
		return 0;
	}
}
