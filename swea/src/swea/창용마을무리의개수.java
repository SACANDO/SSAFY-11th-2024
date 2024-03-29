package swea;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class 창용마을무리의개수 {
	
	static boolean[] isVisited;
	static Queue<Integer> num = new LinkedList<>();
	static List<Integer>[] rel;
	static Queue<Integer> queue = new LinkedList<>();
	static int cnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		int tc = sc.nextInt();
		for(int t=1; t<=tc; t++) {
			int n= sc.nextInt();
			int m = sc.nextInt();
			rel = new LinkedList[n+1];
			isVisited = new boolean[n+1];
			for(int i=1; i<n+1; i++) {
				rel[i] = new LinkedList<>();
				num.offer(i);
			}
			for(int i=0; i<m; i++) {
				rel[sc.nextInt()].add(sc.nextInt());
			}
			
			while (!num.isEmpty()) {
				int curr = num.poll();
				isVisited[curr]=true;
				cnt++;
				while(!queue.isEmpty()) {
					for(int i=0; i<rel[curr].size(); i++) {
						if(!isVisited[rel[curr].get(i)]) {
							queue.offer(rel[curr].get(i));
							isVisited[rel[curr].get(i)]=true;
							num.remove(rel[curr].get(i));
						}
					}
				}
			}
			System.out.println(cnt);
			
		}
		
	}
	

	static String input = "\r\n"
			+ "2\r\n"
			+ "6 5\r\n"
			+ "1 2\r\n"
			+ "2 5\r\n"
			+ "5 1\r\n"
			+ "3 4\r\n"
			+ "4 6\r\n"
			+ "6 8\r\n"
			+ "1 2\r\n"
			+ "2 5\r\n"
			+ "5 1\r\n"
			+ "3 4\r\n"
			+ "4 6\r\n"
			+ "5 4\r\n"
			+ "2 4\r\n"
			+ "2 3";
}
