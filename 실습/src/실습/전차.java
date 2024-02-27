package 실습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 전차 {

	static int wr;
	static int wc;
	static int r;
	static int c;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			char[][] map = new char[h][w];
			for (int i = 0; i < h; i++) {
				map[i] = br.readLine().toCharArray();
				for (int j = 0; j < w; j++) {
					//전차 위치 확보
					if (map[i][j] == '^') {
						dir('U');
						r = i;
						c = j;
					} else if (map[i][j] == 'v') {
						dir('D');
						r = i;
						c = j;
					} else if (map[i][j] == '<') {
						dir('L');
						r = i;
						c = j;
					} else if (map[i][j] == '>') {
						dir('R');
						r = i;
						c = j;
					}
				}
			}
			System.out.print("#" + t + " ");
			for (int i = 0; i < h; i++) {
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < w; j++) {
					sb.append(map[i][j]);
				}
				System.out.println(sb);
			}
			
			
			//명령 입력받기
			int cmdN = Integer.parseInt(br.readLine());
			char[] arr = br.readLine().toCharArray();
			for (int i = 0; i < cmdN; i++) {
				char cmd = arr[i];
				//명령이 S가 아닐때 
				if (cmd != 'S') {
					char cmp =dir(cmd);
					// 이동 시 : .일때 인덱스가 0보다 크거나 같을 때
					if (r + wr >= 0 && r + wr < h && c + wc >= 0 && c + wc < w && map[r + wr][c + wc] == '.') {
						map[r][c]='.';
						r += wr;
						c += wc;
						map[r][c]= cmp;
					} else {
						continue;
					}
				} 
				//명령이 S일 때 
				else {
					int Br = r +wr;
					int Bc = c +wc;

					while (Br >= 0 && Br < h && Bc < w && Bc >= 0 && (map[Br][Bc] == '.' || map[Br][Bc] == '-')) {
						Br += wr;
						Bc += wc;
					}
					if (!(Br >= 0 && Br < h && Bc < w && Bc >= 0)) {
						continue;
					} else {
						if (map[Br][Bc] == '*') {
							map[Br][Bc] = '.';
						} else {
							continue;
						}
					}
				}
				System.out.println();
				for (int k = 0; k < h; k++) {
					StringBuilder sb = new StringBuilder();
					for (int j = 0; j < w; j++) {
						sb.append(map[k][j]);
					}
					System.out.println(sb);
				}
				System.out.println();

			}
			System.out.print("#" + t + " ");
			for (int i = 0; i < h; i++) {
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < w; j++) {
					sb.append(map[i][j]);
				}
				System.out.println(sb);
			}

		}

	}

	static char dir(char c) {
		switch (c) {
		case 'U':
			wr = -1;
			wc = 0;
			return '^';
		case 'D':
			wr = 1;
			wc = 0;
			return 'v';

		case 'L':
			wr = 0;
			wc = -1;
			return '<';

		case 'R':
			wr = 0;
			wc = 1;
			return '>';

		}
		return c;
	}

}
