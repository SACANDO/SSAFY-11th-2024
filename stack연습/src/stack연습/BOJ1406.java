package stack연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1406 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split("");
		List<String> list = new ArrayList<>();
		
		int n = Integer.parseInt(br.readLine());
		int k = str.length;
		for(int i =0; i<k; i++) {
			list.add(str[i]);
		}
		
		for(int t=0; t<n; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			switch(st.nextToken()) {
			case "L" :
				if(k!=0) {
					k--;
				}
				break;
			case "D" :
				if(k!=str.length) {
					k++;
				}
				break;
			case "B" :
				if(k!=0) {
					k--;
					list.remove(k);
				}
				break;
			case "P" :
				list.add(k, st.nextToken());
				k++;
				break;
			}
		}
		for(int i=0; i<list.size(); i++) {
			System.out.print(list.get(i));
		}
	}
}
