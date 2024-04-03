package 최백준강의;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 암호만들기1759 {
	static String[] chosen;
	static List<String[]> list = new LinkedList<>();
	static int l,c,mo,ja;
	static String[] arr;
	static String[] moem = {"a","e","i","o","u"};
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		
		l = Integer.parseInt(line[0]);
		c = Integer.parseInt(line[1]);
		
		chosen=new String[l];
		
		arr = br.readLine().split(" ");
		Arrays.sort(arr);
		
		combination(0,0);
		
		
		for(int i=0; i<list.size(); i++) {
			String[] curr = list.get(i);
			mo =0;
			ja =0;
			for(int j=0; j<l; j++) {
				check(curr[j]);
			}
			if(mo>=1 &&ja >=2) {
				for(String str : curr) {
					System.out.print(str);
				}
				System.out.println();
			}
		}
		
		
		
	}
	
	static void combination(int idx, int cidx) {
		
		if(cidx>=l) {
			
			String[] tmp = Arrays.copyOf(chosen, l);
			list.add(tmp);
			return;
		}
		
		for(int i=idx; i<=c-l+cidx; i++) {
			chosen[cidx]= arr[i];
			combination(i+1,cidx+1);
		}
	}
	
	static void check(String s) {
		boolean flag =false;
		for(String str : moem) {
			if(str.equals(s)) flag = true;
		}
		if(flag) mo++;
		else ja++;
	}
}
