import java.util.Scanner;

public class BOJ5568 {

	static int[] arr, result;
	static boolean[] check;
	static int n, m;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();

		arr = new int[n];
		check = new boolean[n];
		result = new int[m];
		
		for (int i = 0; i < n; i++) {
			arr[i] = i + 1;
		}
		
		backT(0);

	}

	static void backT(int idx) {
		if (idx ==m) {
			for (int i = 0; i < m; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i=0; i<n; i++) {
			//뽑았어
			if(check[i]) continue;
			check[i]=true;
			result[idx]=arr[i];
			backT(idx+1);
			check[i]=false;
			
			//안뽑았어
			
		}
	}
}
