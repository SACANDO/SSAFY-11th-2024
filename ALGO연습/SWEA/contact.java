package swea;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class contact {


	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {

		for (int t = 1; t <= 10; t++) {
			
			//데이터 갯수
			int n = sc.nextInt();
			//출발 정점
			int st = sc.nextInt();
//			System.out.println("n :" + n);
//			System.out.println("st " +st);

			//리스트 길이
			Set<Integer>[] adjlist = new HashSet[101];
			for (int i = 0; i <= 100; i++) {
				adjlist[i] = new HashSet<>();
			}
			
			//데이터의 갯수보다 하나 작은 수까지 탐색해서 데이터 만들기
			for (int i = 0; i < n/2; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				adjlist[a].add(b);

			}
//			System.out.println("t"+t +"입력 끝");
//			
//			System.out.println("간선리스트");
//			for(int i=0; i<101; i++) {
//				if(adjlist[i].size()!=0)System.out.println(i+"번째 정점"+adjlist[i]);
//			}
//
//			
			
			Queue<Integer> queue = new LinkedList<>();

			queue.offer(st);

			boolean[] visited = new boolean[101];
			visited[st] = true;
			int Max = 0;
			
			while (!queue.isEmpty()) {
				
//				System.out.println(queue);
				final int qs = queue.size();

				Max=0;
				//현재 시점 큐에 있는 정점들 숫자 비교 할거임
				for (int i = 0; i < qs; i++) {
//					System.out.println(qs);
					//현재 시작 정점
					int curr = queue.poll();
					visited[curr] = true;
								
					//시작 정점의 간선 리스트
					List<Integer> list = new ArrayList<>(adjlist[curr]);
					
					if (curr > Max) {
						Max = curr;
					}

					for (int j = 0; j < list.size(); j++) {
						if (!visited[list.get(j)]) {
							queue.offer(list.get(j));
							visited[list.get(j)]=true;
						}

					}
					if(queue.isEmpty()) break;
				}
			}
			System.out.println("#" + t + " " +Max);

		}
	}
}
