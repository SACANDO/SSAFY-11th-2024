package 최소신장트리연습;

import java.util.Arrays;

import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ2887 {
	static class Edge implements Comparable<Edge> {
		int st, ed, w;

		public Edge(int st, int ed, int w) {
			this.st = st;
			this.ed = ed;
			this.w = w;
		}

		@Override
		public String toString() {
			return "Edge [st=" + st + ", ed=" + ed + ", w=" + w + "]";
		}

		@Override
		public int compareTo(Edge o) {
			return this.w - o.w;
		}

	}

	static int[] p;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int[][] x = new int[n][2];
		int[][] y = new int[n][2];
		int[][] z = new int[n][2];

		p = new int[n];
		for (int i = 0; i < n; i++) {
			p[i] = i;
		}

		for (int i = 0; i < n; i++) {
			x[i][0]=y[i][0]=z[i][0]=i;
			x[i][1] = sc.nextInt();
			y[i][1] = sc.nextInt();
			z[i][1] = sc.nextInt();

		}

		Arrays.sort(x, (o1,o2) -> {
			return o1[1]-o2[1];
		});
		Arrays.sort(y, (o1,o2) -> {
			return o1[1]-o2[1];
		});
		Arrays.sort(z, (o1,o2) -> {
			return o1[1]-o2[1];
		});

//		
//		System.out.println(Arrays.toString(x));
//		System.out.println(Arrays.toString(y));
//		System.out.println(Arrays.toString(z));

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		for (int i = 0; i < n - 1; i++) {
			pq.add(new Edge(x[i][0], x[i + 1][0], Math.abs(x[i][1] - x[i + 1][1])));
			pq.add(new Edge(y[i][0], y[i + 1][0], Math.abs(y[i][1] - y[i + 1][1])));
			pq.add(new Edge(z[i][0], z[i + 1][0], Math.abs(z[i][1] - z[i + 1][1])));
		}

		int ans = 0;

		while (!pq.isEmpty()) {
			Edge curr = pq.poll();
//			System.out.println(curr.toString());
			int px = findset(curr.st);
			int py = findset(curr.ed);
			// 부모가 같지 않으면 합치고 값 add
			if (px != py) {
				union(px, py);
				ans += curr.w;
			}
//			System.out.println(Arrays.toString(p));
		}
		System.out.println(ans);

	}

	static int findset(int x) {
		if (p[x] != x) {
			p[x] = findset(p[x]);
		}
		return p[x];
	}

	static void union(int x, int y) {
		p[y] = x;
	}
}