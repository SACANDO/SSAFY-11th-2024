package stack연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BOJ1874 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> queue = new LinkedList<>();
		Stack<Integer> stack = new Stack<>();

		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			queue.offer(Integer.parseInt(br.readLine()));
		}

		for (int i = 1; i <= n; i++) {
			while (i < n && queue.peek() != i) {
				stack.push(i++);
				sb.append("+\n");
			}
			if (queue.peek() == i) {
//				sb.append("+\n-\n");
//				queue.poll();
				stack.push(i);
				sb.append("+\n");
			}
			while (!stack.isEmpty() && queue.peek() == stack.peek()) {
				queue.poll();
				stack.pop();
				sb.append("-\n");
			}

		}

		sb.delete(sb.length() - 1, sb.length());
		
		if (queue.isEmpty()) {
			System.out.println(sb);

		} else {
			System.out.println("NO");

		}
	}
}
