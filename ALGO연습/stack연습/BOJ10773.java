package stack연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ10773 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Integer> stack = new Stack<>();
		
		int n = Integer.parseInt(br.readLine());
		for (int i=0; i<n; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num ==0) {
				stack.pop();
			} else {
				stack.push(num);
			}
		}
		int sum =0;
		while (!stack.isEmpty()) {
			sum+=stack.pop();
		}
		System.out.println(sum);
	}
}
