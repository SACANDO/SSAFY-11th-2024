import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class BOJ2636 {
	static class Info{
		boolean isVisited;
		int n;
	}
	static int r, c, cnt, cmp, time;
	static Info[][] map;
	static Queue<Info> search = new LinkedList<>();
	static Queue<Info> cheese = new LinkedList<>();

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] line = br.readLine().split(" ");
		r = Integer.parseInt(line[0]);
		c = Integer.parseInt(line[1]);

		map = new Info[r][c];
		
		for (int i = 0; i < r; i++) {
			String[] line2 = br.readLine().split(" ");
			for (int j = 0; j < c; j++) {
				map[i][j] = new Info();
				map[i][j].n=Integer.parseInt(line2[j]);
				
			}
		}

		
	

	

	}
}
	