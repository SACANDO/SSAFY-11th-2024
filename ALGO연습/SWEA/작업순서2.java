package swea;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class 작업순서2 {
	static boolean[] visited;
	static int[][] adj;
	static Stack<Integer> stack;
	static int v,e;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {

			v = sc.nextInt();
			e = sc.nextInt();
			int[] degree = new int[v + 1];
			visited = new boolean[v + 1];
			adj = new int[v + 1][v + 1];
			stack = new Stack<>();

			for (int i = 0; i < e; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();

				adj[a][b] = 1;
				degree[b]++;
			}
			
//			for(int[] ii : adj) {
//				System.out.println(Arrays.toString(ii));
//			}
//			System.out.println(Arrays.toString(degree));

			// 진입 차수 0인 것들 다 탐색
			for (int i = 1; i < v + 1; i++) {
				if (degree[i] == 0)
					DFS(i); // 시스템 스택을 스택으로 쓰고 있음

			}

			System.out.print("#" + t + " ");
//			System.out.println(stack);
			while (!stack.isEmpty()) {
				System.out.print(stack.pop() + " ");
			}
			System.out.println();

		}
	}

	private static void DFS(int x) {
		visited[x] = true;
//		System.out.println(x);
		for (int i = 1; i < v + 1; i++) {
			if (adj[x][i] == 1 && !visited[i]) {
				DFS(i);
			}
		}

		stack.add(x);
	}
}
