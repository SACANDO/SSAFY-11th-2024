package 연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1912 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] line = br.readLine().split(" ");
		
		//누적합 저장
		int[] prefix_sum = new int[n];
		for (int i = 0; i < n; i++) {
			if (i == 0) {
				prefix_sum[i] = Integer.parseInt(line[i]);
				continue;
			}
			prefix_sum[i] = prefix_sum[i - 1] + Integer.parseInt(line[i]);
		}
		
		//max값 저장
		int max = prefix_sum[0];
		int min = prefix_sum[0];
		int minIdx = 0;
		
		
		
		
		for (int i = 0; i < n; i++) {
			//1. 현재누적합이 max인지 확인 (0~현재 합)
			max = (max > prefix_sum[i] ? max : prefix_sum[i]);
			//2. 현재누적합 - min누적합이 max인지 확인 (구간합)
			if (minIdx < i) {
				max = max > prefix_sum[i] - min ? max : prefix_sum[i] - min;
			}
			//min 갱신
			if (min >= prefix_sum[i]) {
				min = prefix_sum[i];
				minIdx = i;
			}
	
		}
		System.out.println(max);

	}

}