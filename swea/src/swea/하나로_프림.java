package swea;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;



public class 하나로_프림 {
	static class Edge implements Comparable<Edge> {
		int A, B;
		double W;

		public Edge(int a, int b, double w) {
			A = a;
			B = b;
			W = w;
		}

		@Override
		public String toString() {
			return "Edge [A=" + A + ", B=" + B + ", W=" + W + "]";
		}

		@Override
		public int compareTo(Edge o) {
			if (this.W > o.W) {
				return 1;
			} else if (this.W < o.W) {
				return -1;
			}
			return 0;
		}

	}

	public static void main(String[] args) {

		// 일단 다 입력 받는다.
		// edges 배열에 Edge들을 넣는다.
		// a에는 시작정점 b에는 도착정점 w에는 두 좌표의 거리의 제곱*환경부담세율 저장
		// 리스트의 배열에 각각 간선과 
		// pq에 1번 정점의 edge들을 넣는다.
		// 크루스칼 알고리즘을 돌린다. - union할 때마다 ans에 환경부담금을 더한다.
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		for (int t = 1; t <= tc; t++) {
			int n = sc.nextInt(); // 섬의 개수

			int[][] coor = new int[2][n];

			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < n; j++) {
					coor[i][j] = sc.nextInt();
				}
			}
			double e = sc.nextDouble();
			//입력 끝

			boolean[] visited = new boolean[n];

			PriorityQueue<Edge> pq = new PriorityQueue<>();

			visited[0] = true; 
			ArrayList<Edge>[] edges = new ArrayList[n];
			
			for(int i=0; i<n; i++) {
				edges[i]=new ArrayList<>();
			}
			
			// 0번정점과 인접한 친구들을 몽땅 넣어~~
			for(int i=0; i<n; i++) {
				for(int j=i+1; j<n; j++) {
					edges[i].add(new Edge(i,j,(Math.pow(coor[0][i]-coor[0][j],2)+Math.pow(coor[1][i]-coor[1][j],2))*e));

				}
			}
			
			for(ArrayList<Edge> eee : edges) {
//				System.out.println(eee);
//			}
			
			pq.addAll(edges[0]);

			int pick = 1; // 현재 확보한 정점의 개수
			double ans = 0; // 비용도 0

			while (pick != n) {
				
				Edge ee = pq.poll();
				if (visited[ee.B])
					continue; // 이미 해당정점이 방문한 점이라면....

				ans += ee.W; // 해당 간선이 가지고 있는 가중치를 더한다.
				visited[ee.B] = true;
				pick++;
				// 반복문을 돌면서 갱신할 수 있는거 전부 갱신
				pq.addAll(edges[ee.B]);
			}
			System.out.println("#" + t+ " "+Math.round(ans));
		}
	}
}
