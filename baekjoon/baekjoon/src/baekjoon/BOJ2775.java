package baekjoon;

import java.util.Scanner;

public class BOJ2775 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();
		int[][] arr;
		for (int t = 1; t <= tc; t++) {
			int k = sc.nextInt();
			int n = sc.nextInt();

			arr = new int[k + 1][n + 1];

			for (int i = 0; i < k + 1; i++) {
				for (int j = 1; j < n + 1; j++) {
					if (i == 0) {
						arr[i][j] = j;
					} else if (j == 1) {
						arr[i][j] = 1;
					} else {
						arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
					}
				}
			}
			System.out.println(arr[k][n]);
		}
	}
}
