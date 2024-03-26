
public class 부분집합_재귀함수연습1 {
	static String[] sok = {"sangchu","cheese","patti","pickle"};
	static int N,R;
	static boolean[] sel = new boolean[4];

	public static void main(String[] args) {
		N=4;
		R=2;
		powerset(0);
	}

	private static void powerset(int idx) {
		if(idx>=N) {
			String tmp ="";
			for(int i=0; i<N; i++) {
				if(sel[i]) tmp += sok[i]+" ";
			}
			System.out.println(tmp);
			return;
		}
		sel[idx] = true;
		powerset(idx+1);
		
		sel[idx] = false;
		powerset(idx +1);
	}
}
