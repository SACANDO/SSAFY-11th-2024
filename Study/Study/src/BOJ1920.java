import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1920 {
	
	static long[] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//정렬을 한다. 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		arr = new long[n];
		
		String[] line = br.readLine().split(" ");
		for(int i=0; i<n; i++) {
			arr[i] = Long.parseLong(line[i]);
		}
		
		Arrays.sort(arr);
		
		
		int m = Integer.parseInt(br.readLine());
		
		long[] check = new long[m];
		
		String[] line2 = br.readLine().split(" ");
		for(int i=0; i<m; i++) {
			check [i] = Integer.parseInt(line2[i]);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<m; i++) {
			 sb.append(binarySearch(0, n-1, check[i]) + "\n");
		}
		
		System.out.println(sb.toString());
		
	}
	
	static int binarySearch(int st, int ed, long target) {
		
		int mid = (st + ed)/2;
		
		if(arr[mid]==target) return 1; 
		
		if(st>=ed) return 0;
		
		if(arr[mid]<target) {
			return binarySearch(mid+1, ed, target);
		} else {
			return binarySearch(st, mid, target);
		}
	}
}
