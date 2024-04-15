package 순열조합연습;

import java.util.Arrays;

public class 순열_재귀 {
	static int cnt=0;
	static boolean[] check = new boolean[5];
	static int[] arr = {1,2,3,4,5};
	static int[] chosen= new int[5];
	public static void main(String[] args) {
		perm(0);
		System.out.println(cnt);
	}
	static void perm(int idx) {
		if(idx>=5) {
			System.out.println(Arrays.toString(chosen));
			cnt++;
		}
		
		for(int i=0; i<5; i++) {
			if(check[i]) continue;
			chosen[idx] =  arr[i];
			check[i]=true;
			//다음 반복문을 부를 차례
			perm(idx+1);
			//반복문이 끝나면 실행될 코드
			check[i]=false;
		}
	}
}
