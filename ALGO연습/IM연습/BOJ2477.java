import java.util.Scanner;

public class BOJ2477 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		boolean[] flagArr = new boolean[5];
		int[] arr = new int[5];
		int[] no = new int[2];
		int idx = 0;
		for(int i =0; i<6; i++) {
			boolean flag = flagArr[i];
			int n = sc.nextInt();
			int len=sc.nextInt();
			
			if(!flagArr[i]) {
				flagArr[i]=true;
				arr[i]=len;
			} else {
				
			}
		}
		
		System.out.println(no[0]*no[1]);
	}
}
