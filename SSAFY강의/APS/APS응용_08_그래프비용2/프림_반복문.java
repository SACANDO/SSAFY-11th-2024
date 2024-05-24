import java.util.Arrays;
import java.util.Scanner;

public class 프림_반복문 {
	
	static final int INF = Integer.MAX_VALUE; //아주아주 큰값으로 초기화
	
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(input);
		
		int V = sc.nextInt(); //0부터 시작
		int E = sc.nextInt();

		//인접행렬
		int[][] adjArr = new int[V][V];
		
		for(int i = 0 ; i<E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int W = sc.nextInt();
			//무향그래프
			adjArr[A][B] = adjArr[B][A] = W;
		}//입력끝
		
		//방문처리를 위해 배열선언
		boolean[] visited = new boolean[V]; //이거 골랐어!
		int[] p = new int[V]; //내가 어디서 왔는지 이거 문제에 따라서 필요할수도있고, 안할수도 있음
		int[] dist = new int[V]; //key라고 했던 가장 작은 비용을 저장하기 위한 배열
		
		//dist 초기화
		for(int i = 0 ; i<V; i++) {
			dist[i] = INF;
			p[i] = -1;
		}
		
//		Arrays.fill(dist, INF); //하지만 멋지죠?
		
		//임의의 한점을 선택해서 돌려야한다!
		dist[0] = 0; //0번정점부터 할래요
		
		int ans = 0;
		//정점의 개수만큼 돌아도 상관은 없다!
		for(int i = 0 ; i<V-1 ; i++) {
			int min = INF;
			int idx = -1; 
			//아직 안뽑힌 정점들 중 가장 작은 값을 뽑겠다.
			for(int j = 0 ; j<V; j++) {
				if(!visited[j] && dist[j] < min) {
					min = dist[j];
					idx = j;
				}
			}//해당 for문 종료시  idx : 가장 작은 값을 가지고 있고 방문하지 않은 정점이 선택됨.
			visited[idx] = true; //뽑았어!
			//뽑은 친구와 인접한 정점들 중 갱신할 수 있으면 갱신
			for(int j = 0 ; j<V; j++) {
				if(!visited[j] && adjArr[idx][j] != 0 && dist[j] > adjArr[idx][j]) {
					dist[j] = adjArr[idx][j];
					p[j] = idx;
				}
			}
		}//정점을 선택하는 사이클
		
		for(int i = 0 ; i<V; i++) {
			ans += dist[i];
		}
		System.out.println(Arrays.toString(dist));
		System.out.println(Arrays.toString(p));
		System.out.println(ans);
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	static String input = "7 11\r\n" + "0 1 32\r\n" + "0 2 31\r\n" + "0 5 60\r\n" + "0 6 51\r\n" + "1 2 21\r\n"
			+ "2 4 46\r\n" + "2 6 25\r\n" + "3 4 34\r\n" + "3 5 18\r\n" + "4 5 40\r\n" + "4 6 51\r\n" + "";
}
