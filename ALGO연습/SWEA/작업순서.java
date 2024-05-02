package swea;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 작업순서 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			int v = sc.nextInt();
			int e = sc.nextInt();

			int[][] adj = new int[v + 1][v + 1];
			int[] degree = new int[v + 1];

			for (int i = 0; i < e; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();

				adj[a][b] = 1;
				degree[b]++;
			}

			Queue<Integer> queue = new LinkedList<>();

			for (int i = 1; i < v + 1; i++) {
				if (degree[i] == 0) {
					queue.offer(i);
				}
			}

			StringBuilder sb = new StringBuilder();

			while (!queue.isEmpty()) {
				// 진입 차수가 0인 거 중에 하나 꺼내기
				int curr = queue.poll();
				sb.append(curr + " ");
				// 연결된 간선 제거 (진입차수 깎기)
				for (int i = 0; i < v + 1; i++) {
					if (adj[curr][i] == 1) {
						degree[i]--; // 진입차수 하나 깎기
						adj[curr][i] = 0; // 이건 실제로 간선을 삭제하는 것
						if (degree[i] == 0)
							queue.offer(i); // 진입차수가 0이 되었다면 큐에 넣기
					}
				}

			}
			System.out.println("#"+t+" " + sb);
		}
	}
}
