package dp연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ11048 {
	static int N,M;
	static int maze[][];
			
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		N=Integer.parseInt(line[0]);
		M=Integer.parseInt(line[1]);
		maze = new int[N][M];
		for(int i=0; i<N; i++) {
			String[] line2 = br.readLine().split(" ");
			for(int j=0; j<M; j++) {
				maze[i][j]=Integer.parseInt(line2[j]);
				if(i==0&&j>0) maze[i][j]+=maze[i][j-1];
				else if(j==0&&i>0) maze[i][j]+=maze[i-1][j];
			}
		}
		
		for(int i=1; i<N; i++) {
			for(int j=1; j<M; j++) {
				maze[i][j]=Math.max(maze[i-1][j], Math.max(maze[i][j-1],maze[i-1][j-1]))+maze[i][j];
			}
		}
		System.out.println(maze[N-1][M-1]);
	}
}
