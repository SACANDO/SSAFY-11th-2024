
import java.util.PriorityQueue;
import java.util.Scanner;

public class day0215힙 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int t=1; t<=tc; t++) {
			
			PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
				return b - a;
			});
			
			System.out.print("#"+t+" ");
			int n = sc.nextInt();
			for(int i=0; i<n; i++) {
				
				int k = sc.nextInt();
				switch(k) {
				case 1 :
					int x = sc.nextInt();
					pq.add(x);
					break;
					
				case 2 :
					if(pq.isEmpty()) {
						System.out.print("-1 ");
					} else {
						System.out.print(pq.poll()+" ");
					}
					break;
				}
			}
			System.out.println();
		}

	}

}
