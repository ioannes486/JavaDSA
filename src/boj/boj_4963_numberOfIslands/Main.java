package boj.boj_4963_numberOfIslands;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*TODO:
 * - 상수
 *
 * - 변수
 * 	W : 지도의 너비
 *  h : 지도의 높이
 *  50보다 작거나 같은 양의 정수이다
 *
 * - 조건
 *  한 정사각형과 가로, 세로, 대각선으로 연결되어 있는 사각형은 걸어갈 수 있는 사각형이다 -> 8방향 탐색
 * 두 정사각형이 같은 섬에 있으려면 한 정사각형에서 다른 정사각형으로 걸어서 갈 수 있는 경로가 있어야 한다
 *
 * - 구하는 값
 *  * -> 정사각형 묶음의 개수 구하기
 *

 * - 아이디어
 *
 * */

public class Main
{

    static int H,  W, result;
    private static int[] di = {0,1,1,1, 0,-1,-1,-1};
    private static int[] dj = {1,1,0,-1,-1,-1,0,1};
    private static int[][] visited;


    // BFS 만들기
    private static void bfs(int[][] arr, int[] start) {
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        visited[start[0]][start[1]] = 1;

        while (!q.isEmpty()) {
            int[] v = q.remove();
            int i_idx = v[0];
            int j_idx = v[1];

            for (int dir = 0; dir < 8; dir++) {
                int ni = i_idx + di[dir];
                int nj = j_idx + dj[dir];

                if (0 <= ni && ni < H && 0 <= nj && nj< W) {
                    if (arr[ni][nj] == 1 && visited[ni][nj] == 0) {
                        visited[ni][nj] = 1;
                        q.add(new int[] {ni, nj});
                    }
                }
            }
        }

        result++;

    }

    public static void main(String[] args) throws Exception
    {

        // 입출력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());

            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());


            // 맨 끝자리에 0 0을 만나면 종료
            if (W == 0 && H == 0) break;

            int[][] arr = new int[H][W];
            visited = new int[H][W]; // 생각해보니까 배열은 어차피 참조라 스태틱 안해도 됐을 듯?
            result = 0;



            for (int i = 0; i < H; i ++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 완전탐색 돌면서 방문안한 땅만 bfs돌기
            for (int i = 0; i < H; i ++){
                for (int j = 0; j < W; j++){
                    if (arr[i][j] == 1 && visited[i][j] ==0) {

                        // BFS를 한번 돌 때마다 섬의 개수 추가
                        bfs(arr, new int[] {i,j});
                    }

                }
            }
            System.out.println(result);
        }
    }


}