package baekjoon;

import java.util.Scanner;

public class BOJ1934 {
	static int gcd;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int t=1; t<=tc; t++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			gcd=yaksoo(a,b);
			
			int ans = baesoo(a/gcd,b/gcd);
			System.out.println(ans);
		}
	}
	//최소공배수
	static int baesoo(int a, int b) {
		return a*b*gcd;
	}
	
	//최대공약수찾기
	static int yaksoo(int a, int b) {
		
		int mod = a<=b? a:b;
		
		while(mod!=0) {
			
			if(a%mod ==0 && b%mod==0) {
				return mod;
			}
			mod--;
		}
		return 1;
	}
}
