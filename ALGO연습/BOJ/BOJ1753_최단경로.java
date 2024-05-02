import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge>{
	int idx;
	int weight;

	public Edge(int idx, int weight) {
		this.idx=idx;
		this.weight=weight;
	}
	
	@Override
	public int compareTo(Edge o) {
		return this.weight-o.weight;
	}


}
public class BOJ1753_최단경로 {
	//가중치가 작은것 부터 뽑기 위해 p.q사용
	static PriorityQueue<Edge> pq = new PriorityQueue<>();
	
	static List<Edge>[] graph;

	static int[] dist;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		
		int V = Integer.parseInt(line[0]);
		int E = Integer.parseInt(line[1]);
		
		dist = new int[V+1];
		//가중치 최대로 삽입
		Arrays.fill(dist, Integer.MAX_VALUE);
		//시작 버텍스
		int start = Integer.parseInt(br.readLine());
		//시작 버텍스에서 시작버텍스까지의 가중치는 0
		dist[start] =0;
		
		//리스트가 들어있는 배열 초기화
		graph = new ArrayList[V+1];
		
		//각 배열의 인덱스에 list추가
		for(int i=0; i<=V; i++) {
			graph[i] = new ArrayList<>();
		}
		
		//그래프에 값 삽입
		StringTokenizer st;
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			graph[v].add(new Edge(w,cost));
			
		}
	
		//먼저 pq에 시작점 삽입
		pq.offer(new Edge(start,0));
		
		//탐색이 끝난 버텍스인지 체크
		boolean[] check = new boolean[V+1];
		
		while(!pq.isEmpty()) {
			//출발 버텍스
			int nowVertex = pq.poll().idx;
			
			if(check[nowVertex]) continue;
			
			// pq에 들어오면 가중치가 작은 것 부터 방문을 하기 때문에 
			// check되어 있는 건 탐색이 끝난 거
			check[nowVertex] = true;
			
			for(Edge next : graph[nowVertex]) {
				//dist에 저장된 비용보다 next를 거치는 비용이 더 작다면 갱신 
				if(dist[next.idx]>dist[nowVertex]+next.weight) {
					dist[next.idx] = dist[nowVertex]+next.weight;
					
					//더 최단 경로라서 갱신이 된다면 pq에 삽입
					pq.offer(new Edge(next.idx,dist[next.idx]));
				}
			}
		}
		for(int i=1; i<=V; i++) {
			
			if(dist[i]==Integer.MAX_VALUE) {
				System.out.println("INF");
			} else {
				System.out.println(dist[i]);
			}
		}
		
	}
}
