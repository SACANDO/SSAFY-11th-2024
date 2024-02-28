import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] msg = br.readLine().toCharArray();
		int len = msg.length;
		int max = (int)Math.sqrt(len);
		int R = 0;
		int C = 0;
		for(int i=max; i>=1; i--) {
			if(len%i==0) {
				R=i;
				C=len/i;
				break;
			}
		}
		int idx=0;
		char[][] msgArr = new char[R][C];
		for(int j=0; j<C; j++) {
			for(int i=0; i<R; i++) {
				msgArr[i][j]=msg[idx++];
			}
		}
		StringBuilder sb= new StringBuilder();
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				sb.append(msgArr[i][j]);
			}
		}
		
		System.out.println(sb);
		
	}
}