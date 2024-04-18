package baekjoon;

import java.util.Scanner;

public class BOJ2193 {
	static int[] dp0 = new int[91];
	static int[] dp1 = new int[91];
	public static void main(String[] args) {
		dp0[1] =0;
		dp1[1] =1;
		dp0[2] =1;
		dp1[2] =0;
		dp0[3] =
		
		for(int i=2; i<91; i++) {
			dp0[i] = dp0[i-1] +dp1[i-1];
			dp1[i] = dp0[i-1];
		}
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(dp0[n]+dp1[n]);
		
	}
}	
