import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class day0215_농작물 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=tc; t++) {
			int n = Integer.parseInt(br.readLine());
			
			int[][] farm = new int[n][n];
			for(int i=0; i<n; i++) {
				String[] line = br.readLine().split("");
				for(int j=0; j<n; j++) {
					farm[i][j]=Integer.parseInt(line[j]);
				}
			}
			
			int r =n/2;
			int l = n/2;
			int sum =0;
			for(int i=0; i<n; i++) {
				for (int j=l; j<=r; j++) {
					sum+=farm[i][j];
				}

				if (i<n/2) { 
					r++;
					l--;
				}else {
					r--;
					l++;
				}
			}
			System.out.println("#" + " " +sum);
		}
	}
}
