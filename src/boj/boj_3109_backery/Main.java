package boj.boj_3109_backery;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*TODO:
- 상수
    첫째 열은 근처 빵집의 가스관이고
    마지막 열은 원웅이의 빵집이다
- 변수

- 조건
    건물이 있는 경우에는 파이프를 놓을 수 없다.
    가스관과 빵집을 파이프라인은 첫째 열에서 시작해야 한다.
    마지막 열에서 끝나야 한다.
    오른쪽, 위 대각선, 오른쪽 아래 대각선으로 연결할 수 있다.
    각 칸의 중심끼리 연결하는 것
    경로는 겹칠 수 없고, 서로 접할 수 없다.
    한번 지나간 경로는 다시 지나갈 수 없다.

- 구하는 값
    가스관과 빵집을 연결하는 파이프라인의 최대 개수
- 아이디어

*/
public class Main {

    static int R, C;
    static char[][] graph;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        graph = new char[R][C];
        for (int i = 0; i < R; i++){
            graph[i] = br.readLine().toCharArray();
        }


    }
}


