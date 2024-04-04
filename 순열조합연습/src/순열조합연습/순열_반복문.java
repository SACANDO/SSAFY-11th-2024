package 순열조합연습;

public class 순열_반복문 {
	public static void main(String[] args) {
		int cnt=0;
		boolean[] check = new boolean[10];
		
		for(int i=1; i<=9; i++) {
			check[i]=true;
			for(int j=1; j<=9; j++) {
				if(check[j]) continue;
				check[j]=true;
				for(int q = 1; q<=9; q++) {
					if(check[q]) continue;
					check[q] =true;
					System.out.println(i+" "+j+" "+q);
					cnt++;
					check[q]=false;
				}
				check[j]=false;
			}
			check[i]=false;
			
		}
		System.out.println("count : " + cnt);
	}
}
