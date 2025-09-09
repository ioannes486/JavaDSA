package boj.boj_11559_puyopuyo.copy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.LinkedList;
import java.util.Queue;

/*
*todo:
* ?ƒ?ˆ˜
*   R?? ë¹¨ê°•, G?Š” ì´ˆë¡, B?Š” ?ŒŒ?‘, P?Š” ë³´ë¼, Y?Š” ?…¸?‘?´?‹¤.
*   . ë¹ˆê³µê°?
*
* ë³??ˆ˜
* ì¡°ê±´
* êµ¬í•˜?Š” ê°?
*   ?˜„?¬ ë¿Œìš”?—?„œ ?—°?‡„ê°? ?¼?–´?‚˜?Š” ?ˆ˜
*
* ? œ?•½?‚¬?•­
* ?•„?´?””?–´
* */
public class Main {
    static int N= 12;
    static int M = 6;
    static char[][] graph = new char[N][M];
    static int [][] visited = new int[N][M];
    static final int[] di = {0,1,0,-1};
    static final int[] dj = {1,0,-1,0};
    static final char[] colors = {'R', 'G','B','P','Y'};


    // bfsë¡? ê°™ì? ?ƒ‰ê¹? ?ˆœ?šŒ?•˜ê¸?
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
                        // visitedì¦ê??•˜?Š” ë°°ì—´?„ ?™œ?š©?•  ?ˆ˜ê°? ?ˆ?‚˜?
                        // ê±°ë¦¬ë¥? êµ¬í•˜?Š” ê±? ?•„?‹ˆ?‹ˆê¹?
                        visited[ni][nj] = 1;
                        q.add(new int[] {ni, nj});
                        bang++;
                    }
                }

            }
        }
        return bang;

    }

    // ê°? ê·¸ë˜?”„?˜ ? ?— ???•´ ëª¨ë“  ? ?— ???•´ ?ˆœ?šŒ?Œê¸?
    static int puyo() {
        int chainReaction = 0;

        for (int i = 0; i< N; i++) {
            for (int j = 0; j< M; j++){
                int[] start = {i, j};
                for (char color: colors) {
                    int bang = bfs(color,start);
                    if (bang >= 4) {
                        // ì²´ì¸?´ ?˜?Š” ì¡°ê±´?„ ?” ì¶”ê??•´?•¼ ?  ê²? ê°™ë‹¤.
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
