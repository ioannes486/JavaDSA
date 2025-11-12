package boj.boj_2250_width_and_height_of_tree;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*TODO:
- 상수

- 변수

- 조건
    이진트리
    같은 레벨에 있는 노드는 같은 행에 위치한다.
    한 열에는 하나의 노드만 위치한다.
    왼쪽 부트리에 있는 노드들은 해당 노드보다 왼쪽의 열에 위치히고, 오른쪽 부트리에 있는 노드들은 해당 노드보다 왼쪽의 열에 위치
    오른쪽 부트리에 있는 노드들은 해당 노드보다 오른쪽의 열에 위치

    노드가 배치된 가장 왼쪽 열과 오른쪽 열 사이엔 아무 노드도 없이 텅 비어있는 열은 없다.
    너비 = 제일 오른쪽 - 제일 왼쪽 + 1
    레벨은 가장 위 레벨이 1 아래로 1씩 증가함
- 구하는 값

- 아이디어

*/
public class Main {
    static int N;
    static int[][] tree;
    static int[] parents;



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 1. 이진 트리 입출력 받기 N+1 * 2의 형태 배열로 입력을 받고
        // 각각 노드의 레벨이랑 가로
        N = Integer.parseInt(br.readLine());
        tree = new int[N+1][4];
        for (int i = 1; i < N+1; i++){
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c0 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());

            tree[p][0] = c0;
            tree[p][1] = c1;
        }

        // 2. parent 배열 만들어서 루트 찾기
        parents = new int[N+1];
        for (int i = 1; i < N+1; i++){
            int c0 = tree[i][0];
            int c1 = tree[i][1];

            if (c0 != -1) {
                parents[c0] = i;
            }

            if (c1 != -1) {
                parents[c1] = i;
            }
        }

        int root = -1;  // 루트 초기화
        for (int i = 1; i < N+1; i++){
            if (parents[i] == 0){ // 부모가 없으면 루트임
                root = i;
                break; // 리소스 아끼기
            }
        }



    }

    // 3. 루트에서 시작해서 dfs로 레벨 기록하기
    static void markLevel(int currentNode, int level){
        if (tree[currentNode][2] == 0){
            tree[currentNode][2] = level;
        }
    }
}


