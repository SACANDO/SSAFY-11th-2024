import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 다잌스트라_반복문 {
	static class Node {
		int v, w;

		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}

	static final int INF = 987654321;
	static int V, E;
	static List<Node>[] adjList; // 인접리스
	static int[] dist;

	public static void main(String[] args) {
		Scanner sc = new Scanner(input);

		V = sc.nextInt();
		E = sc.nextInt();
		
		adjList = new ArrayList[V];
		for(int i = 0 ; i<V; i++) {
			adjList[i] = new ArrayList<>();
		}//초기화 완료
		
		dist = new int[V];
		Arrays.fill(dist, INF);
		
		for(int i = 0 ; i<E; i++) {
			//시작정점 도착정점 가중치 순으로 입력이 된다.
			adjList[sc.nextInt()].add(new Node(sc.nextInt(), sc.nextInt()));
		}
		
		dijkstra(0);
		
		System.out.println(Arrays.toString(dist));
		
		
		
		
		
		
		
		
		
		

	}

	private static void dijkstra(int start) {
		boolean[] visited = new boolean[V]; //방문처리
		
		dist[start] = 0; //시작 노드까지의 거리는 0으로 초기화
		
		//모든 정점을 다 돌때까지 해보려고 한다. (문제를 보고 도착정점이 주어졌을때, 거기 방문하면 멈춰!)
		for(int i = 0 ; i < V-1; i++) {
			int min = INF;
			int idx = -1;
			
			for(int j = 0 ; j<V; j++) {
				if(!visited[j] && min > dist[j]) {
					min = dist[j];
					idx = j;
				}
			}//idx : 방문하지 않았으면서, 시작정점으로 부터 해당 idx 정점까지의 거리가 최소인 친구가 잡힘
			
			//이거 무슨 소리? 시작정점으로 부터 갈 수 있는 친구들은 다방문했어
			if(idx == -1) break; 
			
			
			visited[idx] = true; //선언
		
			//아래 방법이 훨씬 깔꼬미
			for(Node node : adjList[idx]) {
				if(!visited[node.v] && dist[node.v] > dist[idx]+node.w) {
					dist[node.v]= dist[idx] + node.w; 
				}
			}
		}
	}

	static String input = "6 11\r\n" + "0 1 4\r\n" + "0 2 2\r\n" + "0 5 25\r\n" + "1 3 8\r\n" + "1 4 7\r\n"
			+ "2 1 1\r\n" + "2 4 4\r\n" + "3 0 3\r\n" + "3 5 6\r\n" + "4 3 5\r\n" + "4 5 12\r\n" + "";
}
