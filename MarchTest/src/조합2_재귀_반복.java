import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 조합2_재귀_반복 {
	static String[] 속 = { "상추", "패티", "치즈", "피클" };
	static int N, R;
	static String[] sel;
	static List<String[]> list = new ArrayList<>();
	public static void main(String[] args) {
		N=4;
		R=2;
		sel=new String[R];
		combination(0,0);
		
	}
	private static void combination(int idx, int sidx) {
		if(sidx ==R) {
			String[] tmp = new String[R];
			for(int i=0; i<R; i++) {
				tmp[i] = sel[i];
			}
			
			System.out.println(Arrays.toString(sel));
			list.add(tmp);
			return;
		}	
		if(idx==N) {
			
		}
		
		sel[sidx]=속[idx];
		combination(idx+1,sidx+1);
		combination(idx+1,sidx);
	}
}
