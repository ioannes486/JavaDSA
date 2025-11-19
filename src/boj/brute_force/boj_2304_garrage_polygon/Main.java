package boj.brute_force.boj_2304_garrage_polygon;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*TODO:
- 상수

- 변수
    N : 기둥의 개수 1이상 1000이하

    L, H : 왼쪽 면의 위치와 높이를 나타냄 1이상 1000이하
- 조건
    높이는 다를 수 있다.
    창고에는 모든 기둥이 들어간다.

- 구하는 값
    가장 작은 창고 다각형의 면적
- 아이디어
    좌에서 한번 우에서 한번와서
*/
public class Main {
    static int[] garrage = new int[1001];
    static int leftIndex, rightIndex, maxHeight;
    static int N;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            garrage[L] = H;
        }

        int left = leftLookUp();
        int right = rightLookUp();
        int width = leftIndex - rightIndex;
        int area = (width -1) * maxHeight;

        int result = left + right- area;
        System.out.println(result);

    }

    static int leftLookUp(){
        int area = 0;
        int columnCount = 0;
        leftIndex = 0;
        maxHeight = 0;
        while(columnCount < N){
            if (garrage[leftIndex] > 0){
                columnCount++;
            }

            if (garrage[leftIndex] > maxHeight){
                maxHeight = garrage[leftIndex];
            }

            area = area + maxHeight;
            leftIndex++;
        }
        return area;
    }

    static int rightLookUp(){
        int area = 0;
        int columnCount = 0;
        rightIndex = 1000;
        maxHeight = 0;
        while(columnCount < N){
            if (garrage[rightIndex] > 0){
                columnCount++;
            }

            if (garrage[rightIndex] > maxHeight){
                maxHeight = garrage[rightIndex];
            }

            area = area + maxHeight;
            rightIndex--;
        }
        return area;
    }
}

