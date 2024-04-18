package baekjoon;

import java.util.Scanner;

public class BOJ10872 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		
		int ans = 1;
		while(n>=1) {
			ans*=n;
			n--;
		}
		System.out.println(ans);
	}
}
