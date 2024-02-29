import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] arr;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		arr = new int[n];
		
		
		for(int i=0; i<n; i++) {
			int k = sc.nextInt();
			arr[i] =i+1;
			swap(i,k);
//			System.out.println(Arrays.toString(arr));
		}
		
		for(int stu : arr) {
			System.out.print(stu+" ");
		}
	}
	static void swap(int i, int k) {
		while(k!=0) {
			int tmp = arr[i];
			arr[i] = arr[i-1];
			arr[i-1] = tmp;
			k--;
			i--;
		}
	}
}