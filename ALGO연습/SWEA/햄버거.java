package 실습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 햄버거 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {

			String[] line = br.readLine().split(" ");
			int n = Integer.parseInt(line[0]);
			int c = Integer.parseInt(line[1]);
			int[] prefer = new int[n];
			int[] cal = new int[n];
			int max = 0;

			for (int i = 0; i < n; i++) {
				String[] line2 = br.readLine().split(" ");
				prefer[i] = Integer.parseInt(line2[0]);
				cal[i] = Integer.parseInt(line2[1]);
			}

			for (int i = 0; i < (1 << n); i++) {
				int calS = 0;
				int preS = 0;
				for (int j = 0; j < n; j++) {
					if ((i & 1 << j) > 0) {
						calS+=cal[j];
						preS+=prefer[j];
					}
				}

				// 칼로리도 적고 최대 점수인 것
				if (calS <= c) {
					if (preS > max) {
						max = preS;
					}
				}

			}
			
			System.out.println("#"+t+" " +max);
		}
	}
}
