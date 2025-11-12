<<<<<<<< HEAD:src/boj/unsolved/boj_11559_puyopuyo/copy/Main.java
package boj.unsolved.boj_11559_puyopuyo.copy;
========
package boj.unclassified.boj_11559_puyopuyo.copy;
>>>>>>>> 60271451f6be405a248368dc05074475e09c24df:src/boj/unclassified/boj_11559_puyopuyo/copy/Main.java

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.LinkedList;
import java.util.Queue;

/*
*todo:
* ?��?��
*   R?? 빨강, G?�� 초록, B?�� ?��?��, P?�� 보라, Y?�� ?��?��?��?��.
*   . 빈공�?
*
* �??��
* 조건
* 구하?�� �?
*   ?��?�� 뿌요?��?�� ?��?���? ?��?��?��?�� ?��
*
* ?��?��?��?��
* ?��?��?��?��
* */
public class Main {
    static int N= 12;
    static int M = 6;
    static char[][] graph = new char[N][M];
    static int [][] visited = new int[N][M];
    static final int[] di = {0,1,0,-1};
    static final int[] dj = {1,0,-1,0};
    static final char[] colors = {'R', 'G','B','P','Y'};


    // bfs�? 같�? ?���? ?��?��?���?
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
                        // visited증�??��?�� 배열?�� ?��?��?�� ?���? ?��?��?
                        // 거리�? 구하?�� �? ?��?��?���?
                        visited[ni][nj] = 1;
                        q.add(new int[] {ni, nj});
                        bang++;
                    }
                }

            }
        }
        return bang;

    }

    // �? 그래?��?�� ?��?�� ???�� 모든 ?��?�� ???�� ?��?��?���?
    static int puyo() {
        int chainReaction = 0;

        for (int i = 0; i< N; i++) {
            for (int j = 0; j< M; j++){
                int[] start = {i, j};
                for (char color: colors) {
                    int bang = bfs(color,start);
                    if (bang >= 4) {
                        // 체인?�� ?��?�� 조건?�� ?�� 추�??��?�� ?�� �? 같다.
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
