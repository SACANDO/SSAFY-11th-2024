import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1535 {
	static int[] sum = new int[100]; 
	static int[] weight, happy;

	static boolean[] check;
	static int n;
	static int cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		weight = new int[n];
		happy = new int[n];
		check = new boolean[n];
		
		String[] line = br.readLine().split(" ");
		String[] line2 = br.readLine().split(" ");
		for(int i=0; i<n; i++) {
			weight[i]=Integer.parseInt(line[i]);
			happy[i]=Integer.parseInt(line2[i]);
			if(weight[i]<100) {
				if(sum[i]<happy[i])
				sum[weight[i]]=happy[i];
			}
		}
		
		powerset(0);
		int max = 0;
		for(int i=0; i<100; i++) {
			max= max>sum[i]? max: sum[i];
		}
//		System.out.println(Arrays.toString(sum));
		System.out.println(max);
		System.out.println(cnt);
		
	}
	
	public static void powerset(int idx) {
		cnt++;
		// base case : 재귀를 빠져나갈 조건
		if (idx >= n) {
			int w = 0;
			int h = 0;
			for (int i = 0; i < n; i++) {
				if (check[i]) {
					w+=weight[i];
					h+=happy[i];
				}
			}
//			System.out.println("h : "+h + "w : " + w);
			if(w<100) sum[w]= sum[w]>h? sum[w] : h; 
				
			return; 
		}

		check[idx] = true;
		powerset(idx + 1); 
		check[idx] = false;
		powerset(idx + 1);

	}

}
