import java.util.Scanner;

public class BOJ4811 {

	static long[][] pillcnt = new long[31][31];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 0;
		while ((n = sc.nextInt()) != 0) {
			pillcnt[n-1][1]=1;
			
			
			System.out.println(pillcnt[0][1]);
		}
	}


	static long pill(int w, int h) {
		if(w==0&&h==1) {
			return 1;
		} else if(w>0&&h==0) {
			
			pillcnt[w-1][h+1]++;
		} else if(w>0&&h>0) {
			pillcnt[w-1][h+1]++;
			pillcnt[w][h-1]++;
		} else if(w==0&&h>1) {
			pillcnt[w][h-1]++;
		}
	}
	
}
