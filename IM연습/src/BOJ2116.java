import java.util.Scanner;

public class BOJ2116 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] upidx = {5,3,4,1,2,0};
		int n = sc.nextInt();
		int[][] jusayu = new int[n][6];
		for(int i=0; i<n; i++) {
			for(int j=0; j<6; j++) {
				jusayu[i][j]=sc.nextInt();
			}
		}
		int max =0;
		for(int i=0; i<6; i++) {
			
			int sum=0;
			//첫번째 주사위 윗면 숫자
			int ju0 = jusayu[0][i]; //2,3,1,6,5,4
			//첫번째 주사위옆면에서 제일 큰 숫자 sum에 ++
			int mid =0;

			for (int j=0; j<6; j++) {
				if(j!=i&&j!=upidx[i]) {
					if(jusayu[0][j]>mid) {
						mid=jusayu[0][j];
					}
				}
				
			}
			sum+=mid;

			
			int junext = ju0;
			for(int j=1; j<n; j++) {
				//다음 주사위 아래 숫자와 그 인덱스를 찾아서 또 윗편 주사위 수 정해주기
				

				int junow =0; //아랫면 인덱스
				//1. 위 아래 주사위 인덱스 찾기
				int up = 0;
				for(int q=0; q<6; q++) {
					if(jusayu[j][q]==junext) {
						junow = q; //아랫면 인덱스
						junext = jusayu[j][upidx[q]];//윗면 숫자 갱신
						up = upidx[q];
						
						break;
					}
				}
				
				//
				
				int mid2 = 0;
				for(int k=0; k<6; k++) {
					if(k!=junow&&k!=up) {
						if(jusayu[j][k]>mid2) {
							mid2 = jusayu[j][k];
						}
					}
				}
				sum+=mid2;
			}
			
			if (sum>max) {
				max =sum;
			}
		}
		System.out.println(max);
		
	}
}
