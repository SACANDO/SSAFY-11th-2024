

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9935_1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(br.readLine());
		String str = br.readLine();

		for (int i = 0; i < sb.length() - str.length() + 1; i++) {
			boolean flag = true;

			if (sb.charAt(i) == str.charAt(0)) {
				for (int j = 0; j < str.length(); j++) {
					if (sb.charAt(i + j) != str.charAt(j)) {
						flag = false;
						break;
					}
				}
				if (flag == true) {
					sb.delete(i, i + str.length());

					if (i >= str.length()) {
						i = i - (str.length());
					} else {
						i = -1;
					}
				}
			} 

		}
		if (sb.length()==0) {
			System.out.println("FRULA");
		} else {
			System.out.println(sb);

		}
	}
}
