package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ2628 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		int n = Integer.parseInt(line[0]);
		int m = Integer.parseInt(line[1]);
		
		int[][] map = new int[n][m];
		
		List<Integer> hor = new ArrayList<>();
		List<Integer> ver = new ArrayList<>();
		hor.add(0);
		hor.add(m);
		ver.add(0);
		ver.add(n);
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int t=0; t<tc; t++) {
			String[] line2 = br.readLine().split(" ");
			
			int command = Integer.parseInt(line2[0]);
			int size = Integer.parseInt(line2[1]);
			
			if (command ==0) {
				hor.add(size);
			} else {
				ver.add(size);
			}
		}
		Collections.sort(hor);
		Collections.sort(ver);
	
		int horlen = hor.size();
		int verlen = ver.size();
		int max =0;
		for(int i=1; i<horlen; i++) {
			int height =hor.get(i)-hor.get(i-1);
			for(int j=1; j<verlen; j++) {
				int width = ver.get(j)-ver.get(j-1);
				int result=0;
				if((result=height*width)>max) {
					max = result;
				}
			}
		}
		System.out.println(max);
		
	}
}
