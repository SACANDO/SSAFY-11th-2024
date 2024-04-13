package dp연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1149_RGB거리 {
	static int[][] RGB;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		RGB = new int[N][3];

		for (int i = 0; i < N; i++) {
			String[] line = br.readLine().split(" ");
			RGB[i][0] = Integer.parseInt(line[0]);
			RGB[i][1] = Integer.parseInt(line[1]);
			RGB[i][2] = Integer.parseInt(line[2]);
		}
//		
		for(int i=1; i<N; i++) {
			RGB[i][0] = Math.min(RGB[i-1][1], RGB[i-1][2])+RGB[i][0];
			RGB[i][1] = Math.min(RGB[i-1][0], RGB[i-1][2])+RGB[i][1];
			RGB[i][2] = Math.min(RGB[i-1][1], RGB[i-1][0])+RGB[i][2];
		}
		
		System.out.println(Math.min(RGB[N-1][2], Math.min(RGB[N-1][1], RGB[N-1][0])));
	}
}
