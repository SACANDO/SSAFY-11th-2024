package bfs연습;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class vertax {
	List<Integer> link = new LinkedList<>();
}

public class BOJ1260 {
	static boolean[] visited;
	static Queue<Integer> q = new LinkedList<>();
	static Stack<Integer> st = new Stack<>();
	static vertax[] vertaxArr;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		vertaxArr = new vertax[n+1];
		for(int i=0; i<n+1; i++) {
			vertaxArr[i]=new vertax();
		}
		
		visited = new boolean[n+1];
		
		int m = sc.nextInt();
		int v = sc.nextInt();
		for (int i = 0; i < m; i++) {
			
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			vertaxArr[a].link.add(b);
			vertaxArr[b].link.add(a);
		}

		for(int i=0; i<n+1; i++) {
			Collections.sort(vertaxArr[i].link);
		}
		
		//DFS
		st.push(v);
		dfs();
		
		
		System.out.println();
		for(int i=0; i<n+1; i++) visited[i]=false;
		
		
		//BFS
		q.offer(v);
		while(!q.isEmpty()) {
			int k = q.poll(); // k를 queue에서 뺀다.
			if(!visited[k]) System.out.print(k+" "); //방문하지 않았으면 출력
			visited[k]=true; //방문 처리
			
			for(int i=0; i<vertaxArr[k].link.size(); i++) { //k의 간선들을 방문
				int x = vertaxArr[k].link.get(i);
				if(!visited[x]) {
					q.offer(x);
				}
			}
			
		}
		
		
		
	}
	static void dfs() {
		int k = st.pop();
		if(!visited[k]) System.out.print(k+" "); //방문하지 않았으면 출력
		visited[k]=true; 
		
		for(int i=0; i<vertaxArr[k].link.size(); i++) { //k의 간선들을 방문
			int x = vertaxArr[k].link.get(i);
			if(!visited[x]) {
				st.push(x);
				dfs();
			}
		}
		
	}
}
