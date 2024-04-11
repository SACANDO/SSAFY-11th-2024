package swea;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_1949_등산로조성 {
    
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int N, K, ans;
    
    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++)
        {
            ans = Integer.MIN_VALUE;
            N = sc.nextInt(); // 지도의 크기
            K = sc.nextInt(); // 최대 공사가능 깊이
            int[][] arr = new int[N][N];
            int max = 0;
            
            // 입력을 받는다. 입력을 받으면서 최대 높이를 찾는다.
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    arr[i][j] = sc.nextInt();
                    if (arr[i][j] > max) max = arr[i][j];
                }
            }
            
            // 가장 높은 봉우리 찾아 리스트로 만들기
            // 가장 높은 봉우리가 여러 개가 있다면, 출발점이 여러개가 된다.
            List<int[]> list = new ArrayList<int[]>();
            for (int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if( arr[i][j] == max) list.add(new int[] {i, j});
                }
            }
            
            // 최대 공사 가능 깊이만큼 반복
            for(int k=0; k<=K; k++) {
                for(int r=0; r< N; r++) {
                    for(int c=0; c<N; c++) {
                        if(arr[r][c] - k < 0) continue; // 더이상 깎을 수 없다면 패스
                        
                        arr[r][c] -= k; // 0~ K만큼 깎는다.
                        // 가장 높은 봉우리로부터 출발.
                        for(int i=0; i< list.size(); i++){
                            bfs(list.get(i)[0], list.get(i)[1], arr);
                        }
                        arr[r][c] += k; // 원상복구한다.
                    
                    }
                }
            }
            
            System.out.println("#"+test_case + " " + ans);
        }

        sc.close();
    }

    private static void bfs(int startR, int startC, int[][] arr) {
        Queue<int[]> q = new LinkedList<int[]>();
        q.offer(new int[] {startR, startC});
        int time = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            time++;
            for(int i=0; i<size; i++) {
                int[] cur = q.poll();
                int r = cur[0];
                int c = cur[1];
                for(int d=0; d<4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if(nr < 0 || nr >=N || nc <0 || nc >=N) continue;
                    if(arr[r][c] > arr[nr][nc]) q.offer(new int[] { nr, nc});
                }
            }
        }
        ans = Math.max(ans, time); // 가장 긴 등산로로 업데이트.
    }
}