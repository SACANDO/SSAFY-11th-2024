import java.util.Arrays;

public class 조합_재귀함수 {
	static int[] 속1;
	static int[] 속2;
	static int N, R;
	static int[] sel1;
	static int[] sel2;

	public static void main(String[] args) {
		N=1000;
		R =1000;
		sel1 = new int[R];
		속1 = new int[R];
		sel2 = new int[R];
		속2 = new int[R];
		
		for(int i =0; i<1000; i++) {
			속1[i]=i;
			속2[i]=i;
		}
		combination(0,0);
	}

	private static void combination(int idx, int sidx) {
		if(sidx ==R) {
			System.out.println(Arrays.toString(sel1));
			return;
		}
		
		for(int i=idx; i<=N-R+sidx; i++) {
			sel1[sidx] = 속1[i];
			combination(i+1,sidx+1);
		}
	}
}
