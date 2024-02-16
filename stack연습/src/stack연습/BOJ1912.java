package stack연습;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BOJ1912 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr1 = new int[n];
		int max = -1000;
		int maxidx = 0;
		List<Integer> list = new ArrayList<>();
		List<Integer> input = new ArrayList<>();
		int sum = 0;

		// 1 1 1 -5 2면 3 -5 2로 만들어주기
		// 2 1 -5 4 8 -3 이면 3 -5 12 -3 이런식으로 양수끼리는 더해주기

		for (int i = 0; i < n; i++) {
			arr1[i] = sc.nextInt();
			if (arr1[i] > 0) {
				sum += arr1[i];
				if (i == n - 1) {
					input.add(sum);
				}
			} else {

		}
		System.out.println(input);
		

		// 그 중 젤 큰 값 찾기
		int[] arr2 = new int[input.size()];
		for (int j = 0; j < input.size(); j++) {
			arr2[j] = input.get(j);
			if (arr2[j] > max) {
				max = arr2[j];
			}
		}
		System.out.println(max);

		// max가 여러 개 있을 수 있음 1 1 1 -5 3 은 3 -5 3 이 되고 max인 3이 두개니깐
		for (int i = 0; i < arr2.length; i++) {
			if (arr2[i] == max) {
				list.add(i);
			}
		}


		int result = -1000;
		for (int j = 0; j < list.size(); j++) { // 모든 max값과 그 인덱스에 대해서 조사
			maxidx = list.get(j);
			sum = 0;
			int leftmax = 0;
			for (int i = maxidx - 1; i >= 0; i--) { // max의 왼쪽 방향 조사
				sum += arr2[i];
				if (sum > leftmax) {
					leftmax = sum;
				}
			}
			sum = 0;
			int rightmax = 0;
			for (int i = maxidx + 1; i < arr2.length; i++) { // max의 오른방향 조사
				sum += arr2[i];
				if (sum > rightmax) {
					rightmax = sum;
				}
			}
			if (max + leftmax + rightmax > result) { // 끝~~
				result = max + leftmax + rightmax;
			}
		}

		System.out.println(result);
	}
}