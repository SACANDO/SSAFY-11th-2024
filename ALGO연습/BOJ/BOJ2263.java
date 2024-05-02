package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BOJ2263 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Stack<Integer> stack = new Stack<>();
		Queue<Integer> queue = new LinkedList<>();
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		int[] in = new int[n];
		int[] post = new int[n];

		String[] line = br.readLine().split(" ");
		for (int j = 0; j < n; j++) {
			in[j] = Integer.parseInt(line[j]);
		}

		String[] line2 = br.readLine().split(" ");
		for (int j = 0; j < n; j++) {
			post[j] = Integer.parseInt(line2[j]);
		}

		for (int i = 0; i < n; i++) {
			if (in[i] == post[n - 1]) {
				stack.push(in[i]);
				while (!stack.isEmpty()) {
					sb.append(stack.pop() + " ");
				}
				while (!queue.isEmpty()) {
					sb.append(queue.poll() + " ");
				}
			} else if (i == n - 1) {
				while (!stack.isEmpty()) {
					sb.append(stack.pop() + " ");
				}
				while (!queue.isEmpty()) {
					sb.append(queue.poll() + " ");
				}
			} else if (in[i] == post[i]) {
				stack.push(in[i]);
			} else {
				stack.push(in[i]);
				queue.offer(post[i]);
				if (in[i+1]==post[i] && post[i+1]==in[i]) {
					i++;
				}
			}
		}
		System.out.println(sb);

	}
}
