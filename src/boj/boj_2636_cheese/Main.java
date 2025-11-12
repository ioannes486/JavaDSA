package boj.boj_2636_cheese;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/*TODO:
- 상수

- 변수

- 조건
    구멍을 둘러싼 치즈가 녹아서 구명이 열리면 구멍 속으로 공기가 들어가게 된다.

- 구하는 값
    공기 중에서 치즈가 모두 녹아 없어지는 데 걸리는 시간과 모두 녹기 한 시간 전에 남아있는 치즈조각이 놓여 있는 칸의 개수
- 아이디어
    visited 는 bfs안에서 정의해보자
    ㄴㄴ 밖에서 해야 함 2차원 배열이기 때문
    네방향 순회를 돌아서 공기에 닿은 면적이 하나라도 있으면 visited에 1 체크하기
    but이렇게 하면 구멍이 있는 지 알 수 없음
    구멍이 되는 조건이란?
    1. 공기에 닿은 접촐면이 두개 이상 ㄴㄴ
    2. 바깥쪽 bfs를 돌려서 공기 면을 체크하기
    3. 그렇다면 안쪽 bfs는 돌릴 필요가 없겠네

*/
public class Main {

    static int N, M;
    static int[][] arr;
    static int[][] visited;
    static int cheeseCount;

    static final int[] di = {-1, 1, 0, 0};
    static final int[] dj = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new int[N][M];

        int result = 0;
        while (cheeseRemains()) {
            result ++;
            solve();
        }


        System.out.println(result);
        System.out.println(cheeseCount);

    }

    static void checkAir() {
        Queue<int[]> q = new ArrayDeque<>();

        q.offer(new int[]{0, 0});
        visited[0][0] = 1;

        while (!q.isEmpty()) {

            int[] v = q.poll();

            for (int dir = 0; dir < 4; dir++) {
                int ni = v[0] + di[dir];
                int nj = v[1] + dj[dir];

                if (0 <= ni && ni < N && 0 <= nj && nj < M) {
                    if (visited[ni][nj] == -1 && arr[ni][nj] == 0) {
                        visited[ni][nj] = 1;
                        q.offer(new int[] {ni, nj});
                    }
                }
            }
        }
    }

    static void meltCheeze(int i, int j) {
        for (int dir = 0; dir < 4; dir++) {
            int ni = i + di[dir];
            int nj = j + dj[dir];

            if (0 <= ni && ni < N && 0 <= nj && nj < M) {
                if (visited[ni][nj] == 1) {
                    arr[i][j] = 0;
                    return;
                }
            }
        }
    }

    static void solve(){
        // visited초기화
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], -1);
        }

        // 공기 영역 체크
        checkAir();


        cheeseCount = 0;


        // 외각 치즈 녹이기
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if (arr[i][j] == 1) cheeseCount++;
                meltCheeze(i, j);
            }
        }
    }

    static boolean cheeseRemains(){
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if (arr[i][j] == 1){
                    return true;
                }
            }
        }
        return false;
    }
}


