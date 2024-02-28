import java.util.Arrays;

public class 부분집합_3_재귀함수 {
	static int[] 속;

	static int N, R;
	static boolean[] sel;

	public static void main(String[] args) {
		N = 1000;
		R = 1000;
		sel = new boolean[R];
		속 = new int[R];

		
		for(int i=0; i<1000; i++) {
			속[i]=i;

		}
		powerset(0);
	}

	// idx : 해당 재료의 인덱스
	public static void powerset(int idx) {
		// base case : 재귀를 빠져나갈 조건
		if (idx >= N) {
			String tmp = "";
			for (int i = 0; i < N; i++) {
				if (sel[i])
					tmp += 속[i];
			}
			System.out.println(tmp);
			return; //대전 일동;
		}
		// recursive case : 나 자신을 다시 호출하는 부분
		sel[idx] = true;// 이번 재료 넣었어!
		powerset(idx + 1); // 다음 재료 판단 해줘잉~~

		sel[idx] = false;
		// 이번 재료 안넣었어!
		powerset(idx + 1); // 다음 재료 판단 해줘잉~~

	}
}
