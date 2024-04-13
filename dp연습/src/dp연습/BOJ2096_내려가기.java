package dp연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2096_내려가기 {
	static int[] oneMin,oneMax,twoMin,twoMax,thrMin,thrMax;
	static int[][] Stair;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		Stair = new int[N][3];
		oneMin = new int[N];
		oneMax = new int[N];
		twoMin = new int[N];
		twoMax = new int[N];
		thrMin = new int[N];
		thrMax = new int[N];

		for (int i = 0; i < N; i++) {
			String[] line = br.readLine().split(" ");
			Stair[i][0] = Integer.parseInt(line[0]);
			Stair[i][1] = Integer.parseInt(line[1]);
			Stair[i][2] = Integer.parseInt(line[2]);
		}
		
		oneMin[0]= Stair[0][0];
		twoMin[0]= Stair[0][1];
		thrMin[0]= Stair[0][2];
		
		oneMax[0]= Stair[0][0];
		twoMax[0]= Stair[0][1];
		thrMax[0]= Stair[0][2];
		
		for(int i=1; i<N; i++) {
			oneMin[i] = Math.min(oneMin[i-1], twoMin[i-1])+Stair[i][0];
			twoMin[i] = Math.min(oneMin[i-1], Math.min(twoMin[i-1], thrMin[i-1]))+Stair[i][1];
			thrMin[i] = Math.min(twoMin[i-1], thrMin[i-1])+Stair[i][2];
		}
		
		for(int i=1; i<N; i++) {
			oneMax[i] = Math.max(oneMax[i-1], twoMax[i-1])+Stair[i][0];
			twoMax[i] = Math.max(oneMax[i-1], Math.max(twoMax[i-1], thrMax[i-1]))+Stair[i][1];
			thrMax[i] = Math.max(twoMax[i-1], thrMax[i-1])+Stair[i][2];
		}
		
		System.out.print(Math.max(oneMax[N-1], Math.max(twoMax[N-1], thrMax[N-1]))+" ");
		System.out.print(Math.min(oneMin[N-1], Math.min(twoMin[N-1], thrMin[N-1])));
		
	}
}
