package day0216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 백만장자프로젝트 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			
			int len = Integer.parseInt(br.readLine());
			String[] line = br.readLine().split(" ");
			int max = 0;
			long sum =0;
			
			for(int i=len-1; i>=0; i--) {
				int k = Integer.parseInt(line[i]);
				//처음
				if(k>max) {
					max =k;
				} 
				
				//이후
				else {
					if (max>=k) {
						sum+=max-k;
					} else {
						max=k;
					}
				}
			}
			System.out.println("#"+t +" "+ sum);
		}
		
	}

}