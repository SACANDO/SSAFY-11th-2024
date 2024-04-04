package 최백준강의;

import java.util.Scanner;
import java.util.Stack;

public class 스택수열1874 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();

		stack.push(1);
		sb.append("+\n");

		int i = 2;
		int idx = 0;

		while (idx < n&&i<=n+1) {

			if (stack.isEmpty() || stack.peek() != arr[idx]) {
				stack.push(i++);
				sb.append("+\n");
			} else if (stack.peek() == arr[idx]) {
				stack.pop();
				sb.append("-\n");
				idx++;
//				System.out.println(idx);
			}
		}

//		System.out.println(idx);
		if (!(idx == n))
			System.out.println("NO");
		else {
			System.out.println(sb.toString());
		}
	}
}
