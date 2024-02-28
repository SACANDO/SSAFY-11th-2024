
public class BOJ9251LCS {
	static int N;
	static boolean[] sel;
	static String[] str1, str2;
	public static void main(String[] args) {
		
	}
	
	static void recursion(int idx) {
		
		if(idx>N) {
			String tmp1 = "";
			String tmp2 = "";
			for (int i = 0; i < N; i++) {
				if (sel[i])
					tmp1 += str1[i];
			}
			return;
		}
	}
}

//백만개
//1000000
//for문 두번만 가