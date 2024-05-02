package 재귀연습;

public class BOJ2447 {
	public static void main(String[] args) {
		star(27);
	}

	static void star(int n) {
		
		if (n > 3) {
			star(n / 3);
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i >= n / 3 && i < n - n / 3 && j >= n / 3 && j < n - n / 3) {
					System.out.print(" ");
				} else {
					pattern();
				}
			}
			System.out.println();
		}


	}

	static void pattern() {

		System.out.print("*");
	}

}
