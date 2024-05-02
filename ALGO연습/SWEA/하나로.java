package swea;

import java.util.Arrays;

import java.util.Scanner;

class Edge implements Comparable<Edge> {
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
		if(this.W>o.W) {
			return 1;
		} else if(this.W<o.W) {
			return -1;
		}
		return 0;
	}

}

public class 하나로 {
	static int[] p;
	
	public static void main(String[] args) {
		
		// 일단 다 입력 받는다.
		// edges 배열에 Edge들을 넣는다.
			// a에는 시작정점 b에는 도착정점 w에는 두 좌표의 거리의 제곱*환경부담세율 저장
		// edges를 w로 정렬 한다.
		// 크루스칼 알고리즘을 돌린다. - union할 때마다 ans에 환경부담금을 더한다.
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int t=1; t<=tc; t++) {
			int n = sc.nextInt(); //섬의 개수
			p=new int[n];
			
			for(int i=0; i<n; i++) {
				p[i]=i;
			}
			
			int[][] coor = new int[2][n];
			
			for(int i=0; i<2; i++) {
				for(int j=0; j<n; j++) {
					coor[i][j]=sc.nextInt();
				}
			}
			double e = sc.nextDouble();

//			
			//edges 저장
			
			Edge[] edges = new Edge[(n*(n-1))/2];
			int elen = (n*(n-1))/2;
			int idx=0;
			for(int i=0; i<n; i++) {
				for(int j=i+1; j<n; j++) {
					edges[idx++] = new Edge(i,j,(Math.pow(coor[0][i]-coor[0][j],2)+Math.pow(coor[1][i]-coor[1][j],2))*e);
//					System.out.println(edges[idx-1].W);
				}
			}
			//w로 정렬
			Arrays.sort(edges);
			
			double money=0;
			int pick=0;
			
			for(int i =0; i<elen; i++) {
				Edge ed = edges[i];
//				System.out.println(ed.W);
				int px = findset(ed.A);
				int py = findset(ed.B);
//				System.out.println(ed.W);
				if(px!=py) {
					union(px,py);
					money+=ed.W;
					pick++;
				}
				if(pick==n-1) {
					break;
				}
			}
			
			System.out.println("#"+t+" " +Math.round(money));
		}
		
		//
		
		
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
