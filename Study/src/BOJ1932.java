import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1932 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[][] tri = new int[n][n];

		for (int i = 0; i < n; i++) {
			String[] line = br.readLine().split(" ");
			for (int j = 0; j <= i; j++) {

				tri[i][j] = Integer.parseInt(line[j]);

			}
		}
		int max = -1;
		//트리 깊이가 2이상일 때
		if (n > 1) {
			//일단 뎁스2의 노드에는 값이 정해져 있으니 저장
			tri[1][0] += tri[0][0];
			tri[1][1] += tri[0][0];
			
			//그 다음부터는 그냥 다음 뎁스의 i인덱와 i-1인덱스 중에 큰 거를 더함
			for (int i = 2; i < n; i++) {
				for (int j = 0; j <= i; j++) {
					if (j == 0) {
						tri[i][j] += tri[i - 1][j];
					} else {
						tri[i][j] += Math.max(tri[i - 1][j], tri[i - 1][j - 1]);
					}
				}

			}
			//마지막 노드들에서 가장 큰거 찾음
			for (int i = 0; i < n; i++) {

				if (max < tri[n - 1][i]) {
					max = tri[n - 1][i];
				}
			}

		} 
		//트리 깊이가 1일때
		else {
			max = tri[0][0];
		}
		System.out.println(max);
	}
}