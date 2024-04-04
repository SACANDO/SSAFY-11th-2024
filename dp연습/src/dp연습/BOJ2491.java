package dp연습;

import java.util.Scanner;

public class BOJ2491 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] arr = new int[n];
		if (n <=2)
			System.out.println(n);
		else {

			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			int max=2;
			
//			}
			System.out.println(max);
		}
	}
}
