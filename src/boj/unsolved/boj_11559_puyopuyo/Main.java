package boj.unsolved.boj_11559_puyopuyo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.LinkedList;
import java.util.Queue;

/*
*todo:
* 상수
*   R은 빨강, G는 초록, B는 파랑, P는 보라, Y는 노랑이다.
*   . 빈공간
*
* 변수
* 조건
* 구하는 값
*   현재 뿌요에서 연쇄가 일어나는 수
*
* 제약사항
* 아이디어
* */
public class Main {
    static int N= 12;
    static int M = 6;
    static char[][] graph = new char[N][M];
    static int [][] visited = new int[N][M];
    static final int[] di = {0,1,0,-1};
    static final int[] dj = {1,0,-1,0};
    static final char[] colors = {'R', 'G','B','P','Y'};


    // bfs로 같은 색깔 순회하기
    static int bfs(char color, int[] start){
        int bang = 0;
        Queue<int[]> q = new LinkedList<>();

        q.add(start);
        visited[start[0]][start[1]] = 1;

        while (!q.isEmpty()) {

            int[] v = q.remove();

            for (int i = 0; i < 4; i++) {
                int ni = v[0] + di[i];
                int nj = v[1] + dj[i];
                if (0<=ni && ni<N && 0<=nj && nj < M) {
                    if (graph[ni][nj] == color && visited[ni][nj] == 0) {
                        // visited증가하는 배열을 활용할 수가 있나?
                        // 거리를 구하는 건 아니니깐
                        visited[ni][nj] = 1;
                        q.add(new int[] {ni, nj});
                        bang++;
                    }
                }

            }
        }
        return bang;

    }

    // 각 그래프의 점에 대해 모든 점에 대해 순회돌기
    static int puyo() {
        int chainReaction = 0;

        for (int i = 0; i< N; i++) {
            for (int j = 0; j< M; j++){
                int[] start = {i, j};
                for (char color: colors) {
                    int bang = bfs(color,start);
                    if (bang >= 4) {
                        // 체인이 되는 조건을 더 추가해야 될 것 같다.
                        chainReaction++;
                    }
                    System.out.println(chainReaction);
                }
            }
        }
        return chainReaction;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < N; i++) {
            graph[i] = br.readLine().toCharArray();
        }



        System.out.println(puyo());
    }
}
