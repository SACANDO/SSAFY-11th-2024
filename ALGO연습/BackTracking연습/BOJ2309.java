import java.util.Arrays;
import java.util.Scanner;

public class BOJ2309 {
	static int[] tall=new int[9];
	static int[] dwarf = new int[7];
	static boolean[] check = new boolean[9];
	static final int seven = 7;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<9; i++) {
			tall[i] = sc.nextInt();
		}
		
	}
	static void combination(int idx, int sidx) {
		
		if(sidx==7) {
			Arrays.sort(null);
		}
	}
}
