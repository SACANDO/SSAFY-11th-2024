package 데이크스트라연습;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ4485 {
	
	static class Node implements Comparable<Node>{
		int r,c,w;

		public Node(int r, int c, int w) {
			this.r = r;
			this.c = c;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.w-o.w;
		}
	}
	
	static PriorityQueue<Node> pq = new PriorityQueue<>();
	static int R;
	static int[][] map; //map값이 곧 
	static boolean[][] visited;
	static int[][] money;
	static int[] dr= {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	static int sum;
	static int idx;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			idx++;
			R = sc.nextInt();
			if(R==0) {
				break;
			}
			
			map = new int[R][R];
			visited=new boolean[R][R];
			money=new int[R][R];
			
			for(int i=0; i<R; i++) {
				for(int j=0; j<R; j++) {
					money[i][j]=Integer.MAX_VALUE;
				}
			}
		
			
			for(int i=0; i<R;i++) {
				for(int j=0; j<R; j++) {
					map[i][j]=sc.nextInt();
				}
			}
			money[0][0] = map[0][0];
			pq.add(new Node(0,0,map[0][0]));
			
			while (!pq.isEmpty()) {
				Node curr = pq.poll();
				if(visited[curr.r][curr.c]) continue;
				//방문 표시는 pq에서 뽑히고 해야 함
				visited[curr.r][curr.c]=true;
				
				//사방탐색해서 방문 할 곳 탐색. 기존 값보다 작은 값으로 갱신되면 offer
				for(int i=0; i<4; i++) {
					int rr= curr.r+dr[i];
					int cc=curr.c+dc[i];
					if(rr<R&&rr>=0&&cc>=0&&cc<R&&!visited[rr][cc]&&curr.w + map[rr][cc]<money[rr][cc]) {
//						System.out.println(curr.w + map[rr][cc]);
						money[rr][cc]=curr.w + map[rr][cc];
						pq.offer(new Node(rr,cc,curr.w + map[rr][cc]));
//						visited[rr][cc]=true;
					}

				}
			}
			System.out.println("Problem "+ idx +": "+money[R-1][R-1]);
			
		
		}
	}
}
