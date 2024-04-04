package swea;

import java.util.Scanner;

class Edge{
	int comm, a,b;
	public Edge(int comm,int a, int b) {
		this.comm = comm;
		this.a=a;
		this.b=b;
	}
}

public class 서로소집합 {
	static int[] p;
	static Edge[] edges;
	public static void main(String[] args) {
		//0을 입력받으면 union하기
		//1을 입력받으면 findset하고 그 두 대표자가 같으면 1 아니면 0출력
		
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t=1; t<=tc; t++) {
			int v = sc.nextInt();
			int m = sc.nextInt();
			
			p=new int[v+1];
//			edges= new Edge[m];
			
			for(int i=1; i<=v; i++) {
				p[i]=i;
			}
			System.out.print("#"+t+" ");
			for(int i=0; i<m; i++) {
				Edge edge = new Edge(sc.nextInt(),sc.nextInt(),sc.nextInt());
				int px = findset(edge.a);
				int py = findset(edge.b);
				if(edge.comm ==0) {
					
					union(px,py);
					
				} else if(edge.comm ==1) {
					if(px==py) {
						System.out.print(1);
					} else {
						System.out.print(0);
					}
				}
			
			}
			
			
			System.out.println();
		}
		
		
	}
	
	
	static void union(int x,int y) {
		p[y]=x;
	}
	static int findset(int x) {
		if(p[x]!=x) {
			p[x]=findset(p[x]);
		}
		return p[x];
	}
}
