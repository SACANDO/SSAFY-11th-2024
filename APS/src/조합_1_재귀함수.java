import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 조합_1_재귀함수 {
	// 데이터 배열
	static int[] 속1;
	static int[] 속2;
	static int N, R;
	static int[] sel1;
	static int[] sel2;
	public static void main(String[] args) {
		N = 1000;
		R = 1000;
		sel1 = new int[R];
		속1 = new int[R];
		sel2 = new int[R];
		속2 = new int[R];
		
		for(int i=0; i<1000; i++) {
			속1[i]=i;
			속2[i]=i;
		}
		combination(0,0);
	}
	
	//idx : 현재 내가 판단할 재료
	//sidx : 조합할 재료의 인덱스
	public static void combination(int idx, int sidx) {
		//base case
		if(sidx == R) {
			System.out.println(Arrays.toString(sel1));
			return;
		}
		
		//idx가 경계를 벗어날 걱정을 할필요가 없다. 
		
		//recursive case
		for(int i = idx; i<= N-R+sidx; i++) {
			sel1[sidx] = 속1[i]; //재료 뽑았어요~~
			combination(i+1, sidx+1);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}