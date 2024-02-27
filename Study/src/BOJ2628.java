import java.util.Scanner;

public class BOJ2628 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int repeat = sc.nextInt();
        int[] arr0 = new int[101];
        int[] arr1 = new int[101];

        for (int i = 0; i < repeat; i++) {
            int c = sc.nextInt();
            int pos = sc.nextInt();
            if (c == 0) {
                arr0[pos]++;
            } else {
                arr1[pos]++;
            }
        }

        int idxa = 0;
        int idxb = 0;
        int max = 0;

        for (int i = 0; i <= M; i++) {
            if (arr0[i] !=0) {
                idxb = i;
                max = Math.max(max, idxb - idxa);
                idxa = idxb;
            }
        }
        max = Math.max(max, M - idxa);

        idxa = 0;
        idxb = 0;
        int max2 = 0;
        for (int i = 0; i <= N; i++) {
            if (arr1[i] != 0) {
                idxb = i;
                max2 = Math.max(max2, idxb - idxa);
                idxa = idxb;
            }
        }
        max2 = Math.max(max2, N - idxa);

        System.out.println(max * max2);
    }
}