package baekjoon;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ13549 {

	static int[] time = new int[200000];
	static boolean[] visited = new boolean[200000];
	static int k;
	static PriorityQueue<int[]> pq = new PriorityQueue<>((s1, s2) -> {
		return s1[1] - s2[1];
	});

	public static void main(String[] args) {


		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		k = sc.nextInt();

		
		Arrays.fill(time, Integer.MAX_VALUE);
		time[n] = 0;

		
		if (k <= n) {
			System.out.println(n - k);
		} else {
			// 출발 위치를 넣는다.
			// 배열은 위치, 초
			pq.offer(new int[] { n, 0 });
			
			while (!pq.isEmpty()) {
				int[] curr = pq.poll();
				
				// 값 갱신 된 곳이면 리턴
				if (visited[curr[0]])
					continue;
//				System.out.println(Arrays.toString(curr));
				
				// 동생의 위치에 도달 했다면 리턴
				if (curr[0] == k) {
					System.out.println(curr[1]);
					break;
				}

				
				visited[curr[0]] = true;

				
				int add = curr[0] + 1;
				if (boundary(add) && !visited[add])
					if (time[add] > curr[1]+1) {
						time[add] = curr[1]+1;
						pq.offer(new int[] { add, curr[1] + 1 });
					}
				
				int sub = curr[0] - 1;
				if (boundary(sub) && !visited[sub])
					if (time[sub] > curr[1]+1) {
						time[sub]=curr[1]+1;
						pq.offer(new int[] { sub, curr[1] + 1 });
					}
				
				int mul = curr[0] * 2;
				if (boundary(mul) && !visited[mul])
					if (time[mul] > curr[1]) {
						time[mul] = curr[1];
						pq.offer(new int[] { mul, curr[1]});

					}
			}
		}

	}

	static boolean boundary(int n) {
		return n >= 0 && n < k*2;
	}
}
