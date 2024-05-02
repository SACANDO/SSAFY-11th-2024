import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BOJ16235 {
	static Info[][] land;
	static int N, M, K;
	// 땅<= 10 , 나무< = 100 , 년수 <= 1000

	static class Info {
		int mineral = 5;
		int A;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] line = br.readLine().split(" ");

		N = Integer.parseInt(line[0]);
		M = Integer.parseInt(line[1]);
		K = Integer.parseInt(line[2]);

		land = new Info[N][N];
		
		for(int i=0; i<N; i++) {
			Arrays.fill(land[i], new Info());
		}
		
		for(int i=0; i<N; i++) {
			String[] line3 = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				land[i][j].A = Integer.parseInt(line3[j]);
			}
		}
		
		for (int i = 0; i < M; i++) {
			String[] line4 = br.readLine().split(" ");
			int r = Integer.parseInt(line4[0]);
			int c = Integer.parseInt(line4[1]);
			int age = Integer.parseInt(line4[2]);
			land[r-1][c-1].pq.offer(age);
		}
		
		//---------------------입력 끝
		
		for(int i=0; i<K; i++) {
			spring();
			summer();
			fall();
			winter();
		}
	}

	static void spring() {
		// 나이만큼 양분 먹기 
		
		// 나이만큼 양분 못 먹으면 죽는다 -> summer에게 반환
		// 나이 1 증가 하기
		// 한칸에 나무가 여러개면 어린 나무부터 양분 먹기
		
		

	}

	static void summer() {
		// 봄에 죽은 나무가 양분으로 변함 -> 해당 좌표에 "나무나이/2" 추가
	}

	static void fall() {
		// 나무 나이가 %5==0 인 것들은 번식
		// 번식하면 상하좌우대각선칸에 나이가 1인 나무가 생김
	}

	static void winter() {
		// 각 칸에 추가되는 양분은 A[r][c]
	}

	static boolean boundary() {
		return false;
	}

}
