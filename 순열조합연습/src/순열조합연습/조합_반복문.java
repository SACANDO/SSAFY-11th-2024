package 순열조합연습;

public class 조합_반복문 {
	public static void main(String[] args) {
		int cnt=0;
		for(int i=1; i<=9-2; i++) {
			for(int j=i+1; j<=9-1; j++) {
				for(int q = j+1; q<=9; q++) {
					if(i==j || i==q || j==q) continue;
					System.out.println(i+" "+j+" "+q);
					cnt++;
				}
			}
		}
		
		//넣었다 안 넣었다로 푸는 방법은?
		//이 방법으로 갯수 제어는 일단 다 뽑아 놓고 1이 n개 인것만 추출 하는 방법 밖에!
		System.out.println("count : " + cnt);
	}
}
