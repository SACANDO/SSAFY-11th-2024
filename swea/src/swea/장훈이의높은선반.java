package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 장훈이의높은선반 {
	static int N, B;
	
	static int[] tall;
	static boolean[] checked;
	static int min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=tc; t++) {
			String[] line = br.readLine().split(" ");
			N=Integer.parseInt(line[0]);
			B=Integer.parseInt(line[1]);
			tall=new int[N];
			checked = new boolean[N];
			min = Integer.MAX_VALUE;
			String[] line2 = br.readLine().split(" ");
			for(int i=0; i<N; i++) {
				tall[i]=Integer.parseInt(line2[i]);
			}
			
			comb(0);
			System.out.println("#"+t+" " +(min-B));
		}
	}

	static void comb(int idx) {
		if (idx >= N) {
			check();
			return;
		}
		
		checked[idx]=true;
		comb(idx+1);
		checked[idx]=false;
		comb(idx+1);
	}

	static void check() {
		int t = 0;
		for (int i = 0; i < N; i++) {
			if (checked[i]) {
				t+=tall[i];
			}
		}
		if(t>=B && t<min) {
			min = t;
		}
	}
}
