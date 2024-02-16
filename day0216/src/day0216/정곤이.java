package day0216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 정곤이 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {

			int n = Integer.parseInt(br.readLine());
			String[] line = br.readLine().split(" ");
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(line[i]);
			}

			int max = 0;
			for (int i = 0; i < n - 1; i++) {
				for (int j = i + 1; j < n; j++) {
					int k = 10;
					int num = arr[i] * arr[j];
					
					boolean f = true;
					
					while (num!= 0) {
						int div = num % 10;
						if (div <= k) {
							k = div;
							num /= 10;
						} else {
							f= false;
							break;
						}
					}

					if (f) {
						if (arr[i] * arr[j] > max) {
							max = arr[i] * arr[j];
						}
					}
				}
			}
			
			if (max == 0) {
				System.out.println("#" + t + " -1");
			} else {
				System.out.printf("#%d %d\n", t, max);

			}
		}
	}
}
