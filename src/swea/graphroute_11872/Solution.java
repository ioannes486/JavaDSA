package swea.graphroute_11872;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/*TODO:
- 상수

- 변수

- 조건

- 구하는 값

- 아이디어

*/
public class Solution {

    static int V, E, S, G;
    static int[][] arr;
    static List<List<Integer>> graph;



    static void dfs() {

    }

    static int solve(){
        int[] visited = new int[V+1];
        return 0;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for(int test_case = 1; test_case <= T; test_case++)
        {
            st = new StringTokenizer(br.readLine());

            // V, E초기화
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            // graph초기화 후 2차원리스트로 만들기
            graph = new ArrayList<>();
            for(int i=0; i<=V; i++) graph.add(new ArrayList<>());

            for(int i=0; i<E; i++){
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                graph.get(u).add(e);
            }

            st = new StringTokenizer(br.readLine());
            S = Integer.parseInt(st.nextToken());
            G = Integer.parseInt(st.nextToken());

//            System.out.print("#%d %d%n", test_case, solve());



            // 그래프 출력해보기
//            // 1. 향상된 for문 활용
//            for(List<Integer> elem : graph)
//            {
//                System.out.print("[");
//                for(int number : elem){
//                    System.out.print(number + " ");
//                }
//                System.out.print("]");
//                System.out.println();
//
//            }
//
//            // 2. 함수형 프로그래밍 사용하기
//
//            for (int i = 1; i < graph.size(); i++){
//                String string = graph.get(i).stream()
//                        .map(String::valueOf)
//                        .collect(Collectors.joining(", "));
//
//                System.out.printf("%2d -> %s%n", i, string);
//            }



//            System.out.printf("#%d %s", test_case, Arrays.deepToString(arr));



        }
    }
}

