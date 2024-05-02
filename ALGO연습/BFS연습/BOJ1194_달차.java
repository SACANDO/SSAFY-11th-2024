import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BOJ1194_달차 {
	static Map<Character, Character> DK = new HashMap<>();
	static List<Character> key = new ArrayList<>();
	static List<Character> door = new ArrayList<>();
	static boolean[][] visited;
	static char[][] maze;
	static int N, M;

	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		DK.put('a', 'A');
		DK.put('b', 'B');
		DK.put('c', 'C');
		DK.put('d', 'D');
		DK.put('e', 'E');
		DK.put('f', 'F');

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] line = br.readLine().split(" ");
		N = Integer.parseInt(line[0]);
		M = Integer.parseInt(line[1]);

		maze = new char[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			maze[i] = br.readLine().toCharArray();
		}

		// '.' : 이동
		// 키
		// key리스트에 넣는다
		// '.'로 바꾼다
		// door리스트에서 못 연 문들 중 열수 잇는 게 있는지 찾는다.
		// 있으면 그 문을 '.'로 바꾼다.
		// 문
	}

	static boolean inspection(char c) {
		//길일 때
		if(c=='.') {
			return true;
		}
		
		// 열쇠일 때
		else if(c>=97 && c<=102) {
			return true;
		} 
		
		//문일 때
		else if (c>=65 && c<=70) {
			if(findkey(c)) return true;
			
			key.add(c);
		}
		
		return false;
	}
	
	static boolean findkey(char cc) {
		return false;
	}
}