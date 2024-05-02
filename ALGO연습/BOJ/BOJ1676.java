package baekjoon;

import java.util.Scanner;

public class BOJ1676 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		
		long curr = 1;
		while(n>=1) {
			curr*=n;
			n--;
			System.out.println(curr);
		}
		
		int ans =0;
		while(curr%10==0) {
			ans++;
			curr/=10;
		}
		
		System.out.println(ans);
	}
}
