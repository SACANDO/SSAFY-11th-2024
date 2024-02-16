package aStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ2579 {

	static List<Integer> list = new ArrayList<>();
	static List<Integer> stair = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			stair.add(Integer.parseInt(br.readLine()));
		}

		if (n == 1) {
			System.out.println(stair.get(0));
		} else if (n == 2) {
			System.out.println(stair.get(0) + stair.get(1));
		} else {
			list.add(stair.get(n - 1));
			list.add(stair.get(n - 2));
			for (int i = n - 3; i >= 0; i++) {
				
				list.add(findMax(i));
			}
		}

	}

	static int findMax(int k) {
		return Math.max();
	}
}
