package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ6588_골드바흐 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		boolean[] primeNum = new boolean[1000001];
		Arrays.fill(primeNum, true);
		primeNum[1] = false;
		
		for (int i = 2; i <= Math.sqrt(1000000); i++) {
			if (!primeNum[i]) {
				continue;
			}

			int idx = i;
			while (idx <= 999999) {
				idx += i;
				if(idx>1000000) break;
				primeNum[idx] = false;
			}
		}
		
		
		int n = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		while (n != 0) {
			
			int a = 3;
			int b = n - 3;
			while (a <= 999999) {
				if (primeNum[a] && primeNum[b])
					break;
				
				a+=2;
				b=n-a;
			}
			
			if(a>999999) sb.append("Goldbach's conjecture is wrong. +\n");
			sb.append(n + " = " + a + " + " + b +"\n");
			
			n = sc.nextInt();

		}
		System.out.println(sb.toString());
	}
}
