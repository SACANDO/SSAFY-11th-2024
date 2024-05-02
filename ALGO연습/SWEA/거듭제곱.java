package 실습;

import java.util.Scanner;

public class 거듭제곱 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t=1; t<=10; t++) {
			
			int k= sc.nextInt();
			int n= sc.nextInt();
			int m= sc.nextInt();
			
			System.out.println("#"+t+" "+recursion(n,m));
		}
		
	}
	
	static int recursion(int n, int m) {
		if(m<=1) {
			return n;
		}
		return n*recursion(n,m-1);
	}
}

