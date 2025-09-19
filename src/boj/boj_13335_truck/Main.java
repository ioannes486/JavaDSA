package boj.boj_13335_truck;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*TODO:
- 상수

- 변수
    N : 트럭의 개수
    W : 다리의 길이
    L : 다리가 버틸 수 있는 최대 하중
- 조건
    트럭의 순서는 바꿀 수 없다. 각각 트럭의 무게는 다르다
    트럭 위에는 단지 w대의 트럭만 동시에 올라갈 수 있다.
    1개 단위 시간에 하나의 단위길이만큼만 이동할 수 있다.

- 구하는 값

- 아이디어

*/
public class Main {
    static int N, W, L;
    static int[] trucks


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        trucks = new int[N];

        for (int i = 0; i < N; i++) trucks[i] = Integer.parseInt(st.nextToken());
    }

    static void solve(){
        int[][] schedule = new int[999999999][N];
        int weightCapacity = L;
        for (int i = 0; i < W; i ++){
            if (weightCapacity >= trucks[i]){
                for (int j = 0; j < 2; j++){

                }
            }
        }


    }
}

