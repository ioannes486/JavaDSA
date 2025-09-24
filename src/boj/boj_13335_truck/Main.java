package boj.boj_13335_truck;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
/*TODO:
- 상수

- 변수

- 조건
    다리 위에 완전히 올라가지 못한 트럭의 무게는 다리위의 트럭들의 무게의 합을 계산할 때 포함하지 않는다.

- 구하는 값

- 아이디어
    while문 사용하기
*/
public class Main {
    static int N, W, L;
    static int[] trucks;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        trucks = new int[N];

    }

    static void solve(){
        Queue<Integer> q = new ArrayDeque<>();
        int[] durations = new int[N];
        int[] indice = new int[N];

        for (int i = 0; i < N; i ++){
            indice[i] = i;
        }
        q.offer(indice[0]);



        int time = 0;
        while (!q.isEmpty()){
            // while문 도는 횟수 만큼 총 시간 하나 늘리기
            time++;
            int totalWeight = 0;
            // 큐 안에 있는 애들을 뺀 다음 경과 시간이 W 미만이면 경과 시간을 늘린 다음 다시 집어넣기
            for (int i = 0; i < q.size(); i++){
                int truck = q.poll();
                if (durations[truck] < W) {
                    q.offer(truck);
                    durations[truck]++;
                    // 다리 위에 남아있는 트럭들의 무게 합 구하기
                    totalWeight = totalWeight + trucks[truck];
                }
            }







        }

    }
}


