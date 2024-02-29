import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		int store = sc.nextInt();
		int[][] map = new int[store][2];
		for (int i = 0; i < store; i++) {
			map[i][0] = sc.nextInt();
			map[i][1] = sc.nextInt();
		}

		int dongdir = sc.nextInt();
		int dong = sc.nextInt();

		int sum = 0;
		for (int i = 0; i < store; i++) {
			if (map[i][0] == dongdir) {
				sum += Math.abs(map[i][1] - dong);
//				System.out.println(sum);
				continue;
			}
			int x = map[i][0] * dongdir;

			int k = map[i][0] + dongdir;
			int st = map[i][1];

			switch (x) {
			case 12:
				sum += Math.min(n + st + dong, n + 2 * m - (st + dong));
				break;
			case 8:
				sum += (m + n - dong - st);
				break;
			case 4:
				if (dongdir == 4) {
					sum += dong + n - st;
				} else {
					sum += st + n - dong;
				}
				break;
			case 6:
				if (dongdir == 2) {
					sum += dong + m - st;
				} else {
					sum += st + m - dong;
				}

				break;
			case 3:
				sum += st + dong;
				break;
			case 2:
				sum += Math.min(m + st + dong, m + 2 * n - (st + dong));
				break;
			}
//			System.out.println(sum);
		}
		System.out.println(sum);
	}
}