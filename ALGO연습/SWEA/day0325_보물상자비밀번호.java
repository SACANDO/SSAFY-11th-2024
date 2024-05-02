package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class day0325_보물상자비밀번호 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			String[] line = br.readLine().split(" ");
			int n = Integer.parseInt(line[0]);
			int k = Integer.parseInt(line[1]);
			StringBuilder sb =null; 
			
			Set<Integer> set = new HashSet<>();
			String[] str = br.readLine().split("");
			
			int idx = 0;
			for (int i = 0; i < n / 4; i++) {
				for (int q = 0; q < 4; q++) {
					sb = new StringBuilder();
					for (int j = 0; j < n / 4; j++) {

						sb.append(str[(idx++)%n]);
					}
//					System.out.println(sb.toString());
					set.add(Integer.parseInt(sb.toString(),16));
					
				}
				idx++;
			}
			
			List<Integer> list = new ArrayList<>(set);
			Collections.sort(list,(s1,s2) -> {
				return s2-s1;
			});

			
			System.out.println("#" + t+" " +list.get(k-1));

		}


	}
}
