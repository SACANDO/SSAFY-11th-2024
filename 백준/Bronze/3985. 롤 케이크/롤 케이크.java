import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int L = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		int[] cake = new int[L+1];
		int noMax=0;
		int noMaxNum=0;
		for(int i=1; i<=N; i++) {
			String[] line = br.readLine().split(" ");
			int s = Integer.parseInt(line[0]);
			int e = Integer.parseInt(line[1]);
			if(e-s > noMax) {
				noMaxNum=i;
				noMax=e-s;
			}
			for(int j=s;j<=e;j++) {
				if(cake[j]==0) {
					cake[j]=i;
				}
			}
		}
		

		int max = 0;
		int num=0;
		for(int i=1; i<=L; i++) {
			
			int cnt =0;
			int k = cake[i];
			if(k==0) {
				continue;
			}

			while (i<=L&&cake[i]==k) {
				cnt++;
				i++;
			}
			i--;
			if(cnt>max) {
				max=cnt;
				num=k;
			}
		}
		System.out.println(noMaxNum);
		System.out.println(num);
	}
}