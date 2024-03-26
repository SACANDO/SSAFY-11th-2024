
public class 부분집합_비트마스크연습 {
	public static void main(String[] args) {
		String[] 재료 = { "단무지", "참치", "햄", "소고기" };
		int N = 4; // 재료는 4개
		int[] sel = new int[N];

		for (int i = 0; i < (1 << N); i++) {
			String tmp = "";
			for (int j = 0; j < N; j++) {
				if ((i & (1 << j)) > 0)
					tmp += 재료[j];
			}
			System.out.println(tmp);
		}

	}
}
