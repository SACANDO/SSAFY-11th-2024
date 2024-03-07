package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ1790 {
	public static void main(String[] args) {
		long[] prefixSum = new long[11];
		long[] sum = new long[11];
		sum[10] = 1;

		for (int i = 1; i < 10; i++) {
			sum[i] = (long) ((long) 9 * Math.pow(10, i - 1));
			prefixSum[i] = sum[i] * i + prefixSum[i - 1];
		}
		prefixSum[10] = prefixSum[9] + 10;
		System.out.println(Arrays.toString(sum));
		System.out.println(Arrays.toString(prefixSum));

		Scanner sc = new Scanner(System.in);

		long n = sc.nextLong();
		long k = sc.nextLong();

		// n이 1500이면 1-9 / 10-99 / 100-999 / 1000-1500
		// n이 총 몇자리인지sum[1]*1 sum[2]*2 ,,, 몫이 0일 때는 수-(Math.pow(10,i-1)+1)*i
		// 몫이 0이 될 때 갯수는 그 수 - 해당 인덱스 10 pow한 거

		long nlen = 0;

		long n2 = n;
		for (int i = 1; i < 11; i++) {
			if (n2 / 10 != 0) {
				n2 /= 10;
				nlen += sum[i] * i;
			} else {
				nlen += ((n - Math.pow(10, i - 1)) + 1) * i;
				break;
			}
		}

//		System.out.println(nlen);

		int idx = 0;

		if (k > nlen) {
			System.out.println("-1");
		} else {
			for (int i = 1; i < 11; i++) {
				if (k <= prefixSum[i] && k > prefixSum[i - 1]) {
					idx = i;
					break;
				}
			}

			// System.out.println(idx);
			// 몇자리 수에 범위에 걸쳐있는지가 idx
			// 자리수를 찾으면

			long kk = k - prefixSum[idx - 1];
			long kres = (long) ((kk / idx - 1) + Math.pow(10, idx - 1));
			long kmod = kk % idx;
			int ans = 0;
			if (kmod == 0) {
				ans = (int) kres % 10;
			} else {
				ans = (int) ((kres + 1) / (Math.pow(10, idx - kmod))) % 10;

			}

			System.out.println(ans);

		}
	}
}
