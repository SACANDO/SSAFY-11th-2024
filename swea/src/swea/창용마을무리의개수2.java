package swea;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 창용마을무리의개수2 {
	static class Edge {
		int A, B;

		public Edge(int a, int b) {
			A = a;
			B = b;
		}

		@Override
		public String toString() {
			return "Edge [A=" + A + ", B=" + B + "]";
		}

	}

	static int[] p; // 대표를 저장할 배열

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		Scanner sc = new Scanner(input);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			
			int V = sc.nextInt(); // 정점의 개수 (정점의 시작 번호)
			int E = sc.nextInt(); // 간선의 개수

			Edge[] edges = new Edge[E];

			for (int i = 0; i < E; i++) {
				edges[i] = new Edge(sc.nextInt(), sc.nextInt());
			}

			p = new int[V + 1];
			for (int i = 1; i < V + 1; i++) {
				p[i] = i;
			}

			int pick = 0; 

			for (int i = 0; i < E; i++) {
				// i번째 간선을 뽑아 두 정점의 대표를 확인!

				int px = findset(edges[i].A);
				int py = findset(edges[i].B);

				if (px != py) {
					union(px, py);
					pick++;
				}
//				System.out.println(Arrays.toString(p));

				


			} // 간선배열을 순회하는 for
			for(int j=1; j<=V; j++) {
				p[j]=findset(p[j]);
			}
//			System.out.println(Arrays.toString(p));
			Set<Integer> set = new HashSet<>();
			for (int i = 1; i < V + 1; i++) {
				set.add(p[i]);
			}
			System.out.println("#"+t+" "+set.size());

		}
	}

	static void union(int x, int y) {
		p[y] = x;
	}

	static int findset(int x) {
		// 패스 콤프레션

		if (x != p[x])
			p[x] = findset(p[x]);
		return p[x];
	}

	static void makeset(int x) {
		p[x] = x;

	}

}
