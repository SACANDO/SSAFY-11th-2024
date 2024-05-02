package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;




public class BOJ17202 {
	static int[][] arr = new int[17][17];

	public static void main(String[] args) throws IOException{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] n1 = new int[8];
		int[] n2 = new int[8];
		String[] line = br.readLine().split("");
		
		for (int i = 0; i < 8; i++) {
			n1[i] = Integer.parseInt(line[i]);
			
		}
		line = br.readLine().split("");
		for (int i = 0; i < 8; i++) {
			n2[i] = Integer.parseInt(line[i]);
		}

		int idx = 0;

		for (int i = 0; i < 8; i++) {
			arr[idx++][idx] = n1[i];
			arr[idx][++idx] = n2[i];

			
		}
		
		for(int i=15; i>=2; i--) {
			for(int j=0; j<i; j++) {
				arr[j][j+1]=(arr[j][j+1]+arr[j+1][j+2])%10;
			
			}
		
		}
		System.out.println(arr[0][1]+""+arr[1][2]);
		
		// (0,1)~(15,16) 첫 저장은 (14,15)까지
		
	}
	

}
