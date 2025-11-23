package boj.boj_7682_tictacto;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*TODO:
- 상수

- 변수

- 조건

- 구하는 값

- 아이디어

*/
public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = br.readLine();
            if (line.equals("end")) break;

            char[] ticTacToe = line.toCharArray();
            System.out.println(Arrays.toString(ticTacToe));
        }
    }
}


