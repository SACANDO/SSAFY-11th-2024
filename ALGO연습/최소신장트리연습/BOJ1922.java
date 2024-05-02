
package 최소신장트리연습;


import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ1922 {
	static class Edge implements Comparable<Edge>{
		int a,b,w;
		public Edge(int a, int b, int w) {
			this.a=a;
			this.b=b;
			this.w=w;
		}
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.w-o.w;
		}
		
		
		
	}
	static int[] p;
	static PriorityQueue<Edge> edges = new PriorityQueue<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		p=new int[n+1];
		
		
		
		for(int i=0; i<m; i++) {
			edges.offer(new Edge(sc.nextInt(),sc.nextInt(),sc.nextInt()));
		}
		
		for(int i=1; i<=n; i++) {
			p[i] =i;
		}

		int pick =0; 
		long ans=0;
		for(int i=0; i<m; i++) {
			Edge edge = edges.poll();
//			System.out.println(edge.w);
			int px = findset(edge.a);
			int py = findset(edge.b);
			
			if(px!= py) {
				union(px,py);
				pick++;
				ans+=edge.w;
			}
			if(pick==n-1) {
				break;
			}
		}
		System.out.println(ans);
		// 4,2,6,3,8
		
	}
	
	static int findset(int x) {
		if(p[x]!=x) {
			p[x]=findset(p[x]);
		}
		return p[x];
	}
	
	static void union(int x, int y) {
		p[y]=x;
	}
}
