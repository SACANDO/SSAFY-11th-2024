import java.util.Scanner;

public class BOJ9655 {
	static boolean flag = false;
	static int[][] arr = new int[1000][1000];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

//		int n = sc.nextInt();
//		game(0,n);
//		
//		if(flag) {
//			System.out.println("SK");
//		} else {
//			System.out.println("CY");
//		}

		for(int n =1; n<=1000; n++) {
			game(0,n);
			
			if(flag) {
//				System.out.println("SK");
			} else {
				System.out.println("CY");
		}
		}
		
		// 몇번째인지
		// 몇개 돌 가져갔는지
		// (번째,몇개)
		// 홀수번에서 n으로 끝나는게 있으면 상근이 승
		// 없으면 false 창영이 승

	}

	static int game(int cnt, int n) {

		if (n <= 3) {
			if (((n == 0||n==2) && cnt % 2 == 1) || ((n == 1 || n == 3) && cnt % 2 == 0)) {
				flag = true;
				
			}
			return 1;
		}

		if (arr[cnt + 1][n - 1] != 0) {
			return arr[cnt + 1][n - 1];
		} else {
			arr[cnt+1][n-1]=game(cnt+1,n-1);
		}
		
		if (arr[cnt + 1][n - 3] != 0) {
			return arr[cnt + 1][n - 3];
		} else {
			arr[cnt+1][n-3]=game(cnt+1,n-3);
		}
		
	
		return 1;

	}
}
