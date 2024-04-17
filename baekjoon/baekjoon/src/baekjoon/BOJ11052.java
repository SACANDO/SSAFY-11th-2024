package baekjoon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ11052 {
	static class Info implements Comparable<Info>{
		int value;
		int idx;
		double valueofOne;
		@Override
		public int compareTo(Info o) {
			return -Double.compare(this.valueofOne, o.valueofOne);
		}
		public Info(int value, int idx, double valueofOne) {
			super();
			this.value = value;
			this.idx = idx;
			this.valueofOne = valueofOne;
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		Info[] arr = new Info[n];
		
		for(int i=0; i<n; i++) {
			int a = sc.nextInt();
			arr[i] = new Info(a, i+1, (double)a/(i+1));
		}
		Info[] arr_origin = Arrays.copyOf(arr, n);
		Arrays.sort(arr);
		int ans=0;
		int cnt =0;
//		System.out.println(arr[0].value);
		
		//cnt에 내가 카드를 얼마나 모았는지 저장할거야. idx는 카드 수거든. 그거는 계속 모을 수 있어.
		while(cnt + arr[0].idx <n) {
			ans+=arr[0].value;
			cnt+=arr[0].idx;
		}
		
//		System.out.println(ans);
//		System.out.println(cnt);
		
		if(cnt<n) {
			ans+=arr_origin[n-cnt-1].value;
			System.out.println(ans);
		} else {
			System.out.println(ans);
		}
		

	}
}
