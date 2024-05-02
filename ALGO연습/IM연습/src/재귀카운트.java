import java.util.Scanner;

public class 재귀카운트 {
	
	static Scanner sc = new Scanner(System.in);
	static int N;
	static int branch;
	static int cnt;
	static void func(int index) {
		cnt++;
		System.out.println(cnt);
		if(index == N) {
			return;
		}
		
		for(int i=0; i<branch; i++) {
			func(index +1);
		}
		return;
	}
	
	public static void main(String[] args) {
		branch = sc.nextInt();
		N = sc.nextInt();
		
		func(0);
		System.err.println("total : "+cnt);
		
	}
}
