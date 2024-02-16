package day0216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 러시아국기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			String[] line = br.readLine().split(" ");
			int n = Integer.parseInt(line[0]);
			int m = Integer.parseInt(line[1]);

			char[][] flag = new char[n][m];
			for (int i = 0; i < n; i++) {
				flag[i] = br.readLine().toCharArray();
			}
			int min = 2500;
			for (int u = 0; u < n - 2; u++) {
				for (int d = u + 2; d < n; d++) {
					int i = 0;
					int mid = 0;
					while (i < n) {
						for (int j = 0; j < m; j++) {
							if(i<=u) {
								if(flag[i][j]!='W') {
									mid++;
								}
							} else if (i<d) {
								if(flag[i][j]!='B') {
									mid++;
								}
							}else {
								if(flag[i][j]!='R') {
									mid++;
								}
								
							}
						}
						i++;
					}
					if(mid<min) {
						min=mid;
					}
				}
			}
			System.out.println("#" + t + " " +min);

		}
	}
}
