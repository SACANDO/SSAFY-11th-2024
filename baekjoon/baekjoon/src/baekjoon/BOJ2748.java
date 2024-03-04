package baekjoon;

import java.util.Scanner;

public class BOJ2748 {
	
	static long[] arr;
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N=sc.nextInt();
		arr = new long[N+1];
		arr[0]=0;
		arr[1]=1;
		System.out.println(fibo(N));
	}
	
	static long fibo(int n) {
		
		if(n<=1) return n;
		
		if(arr[n]!=0) {
			return arr[n];
		} else {

			arr[n]=fibo(n-1)+fibo(n-2);
			return arr[n];
		}
	}
}
