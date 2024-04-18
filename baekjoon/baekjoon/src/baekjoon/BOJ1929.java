package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ1929 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		boolean[] primeNum = new boolean[1000000+1];
		Arrays.fill(primeNum,true);
		primeNum[1]=false;
		
		
		for(int i=2; i<=Math.sqrt(m); i++) {
	
			if(!primeNum[i]) continue;
			
			int idx=i;
			while(idx<=m) {
				idx+=i;
				primeNum[idx]=false;
			}	
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=n; i<=m; i++) {
			if(primeNum[i]) sb.append(i+"\n");
		}
		
		System.out.println(sb.toString());
	}
}
