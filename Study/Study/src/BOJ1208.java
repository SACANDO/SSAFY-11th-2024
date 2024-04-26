import java.util.Arrays;
import java.util.Scanner;

public class BOJ1208 {

	static int[] arr1, arr2;
	static int N, S, cnt, mid;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		S = sc.nextInt();
		mid = N / 2;

		for (int i = 0; i < mid; i++) {
			arr1[i] = sc.nextInt();
		}

		for (int i = mid; i < N; i++) {
			arr2[i] = sc.nextInt();
		}

		
		

	}
	
	
	static void one() {
		int result;
		
		for (int j = 0; j < mid; j++) {
			if ((i & (1 << j)) != 0) {
				
			}
		}
		
		two(result);
	}
	
	static void two(int o) {
		int t;
		
		for (int j = 0; j < N - mid; j++) {
			if ((i & (1 << j)) != 0) {
				
			}
		}
				
		check(o,t);
	}
	static void check(int o, int t) {
		if(o==S) cnt++;
		if(t==S) cnt++;
		if(o+t==S) cnt++;
	}

}
