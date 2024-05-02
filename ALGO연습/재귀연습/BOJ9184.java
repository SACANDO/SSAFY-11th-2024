package 재귀연습;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ9184 {
	static int[][][] arr = new int[21][21][21];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int a = 0; a < 21; a++) {
			for (int b = 0; b < 21; b++) {
				for (int c = 0; c < 21; c++) {
					if (a <= 0 || b <= 0 || c <= 0) {
						arr[a][b][c] = 1;
					} else if (a < b && b < c) {
						arr[a][b][c] = arr[a][b][c - 1] + arr[a][b - 1][c - 1] - arr[a][b - 1][c];
					} else {
						arr[a][b][c] = arr[a - 1][b][c] + arr[a - 1][b - 1][c] + arr[a - 1][b][c - 1]
								- arr[a - 1][b - 1][c - 1];
					}
				}
			}
		}

		while (true) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();

			if (a == -1 && b == -1 && c == -1) {
				break;
			} else if (a <= 0 || b <= 0 || c <= 0) {
				System.out.printf("w(%d, %d, %d) = %d", a, b, c, 1);
				System.out.println();
			} else if (a > 20 || b > 20 || c > 20) {
				System.out.printf("w(%d, %d, %d) = %d", a, b, c, arr[20][20][20]);
				System.out.println();
			} else {
				System.out.printf("w(%d, %d, %d) = %d", a, b, c, arr[a][b][c]);
				System.out.println();
			}
		}
	}
}
