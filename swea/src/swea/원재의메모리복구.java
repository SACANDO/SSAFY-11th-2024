package day0216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 원재의메모리복구 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=tc; t++) {
			int sum =0;
			String str = "0";
			String[] mem = br.readLine().split("");
			for(int i=0; i<mem.length; i++) {
				if (!mem[i].equals(str)) {
					str=mem[i];
					sum++;
				}
			}
			System.out.println("#"+t + " " + sum);
		}
	}
}
