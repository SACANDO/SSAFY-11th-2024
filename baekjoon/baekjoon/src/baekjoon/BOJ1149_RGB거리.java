package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1149_RGB거리 {
	static int[] expense;
	static int[][] rgb;
	static int min=Integer.MAX_VALUE;
	static int n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		expense = new int[n];
		rgb = new int[n][3];
		
		for(int i=0; i<n; i++) {
			String[] line = br.readLine().split(" ");
			for(int j=0; j<3; j++) {
				rgb[i][j] = Integer.parseInt(line[j]);
			}
		}
		recursion(0,0);
		
		System.out.println(min);
				
	}
	
	static void recursion(int eIdx, int no) {
//		System.out.println("idx : " + idx + " eIdx : "+eIdx);
//		System.out.println(Arrays.toString(expense));
		
		if(eIdx>=n) {
//			System.out.println("마지막 집까지 합 :" +expense[n-1]);
			if(expense[n-1]<min) {
				min=expense[n-1];
//				System.out.println("min 값" +min);
				return;
			}
			return;
		}
		
		
//		System.out.println(eIdx);
		
		for(int i=0; i<3; i++) {
			if(eIdx>0&&i==no) {
				continue;
			}
		
			if(eIdx ==0) {
			expense[eIdx]=rgb[eIdx][i];
			} else {
				expense[eIdx]=rgb[eIdx][i]+expense[eIdx-1];
			}
			recursion(eIdx+1,i);
			
	}
}
}