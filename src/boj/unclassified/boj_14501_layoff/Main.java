<<<<<<<< HEAD:src/boj/backtracking/boj_14501_layoff/Main.java
package boj.backtracking.boj_14501_layoff;
========
package boj.unclassified.boj_14501_layoff;
>>>>>>>> 60271451f6be405a248368dc05074475e09c24df:src/boj/unclassified/boj_14501_layoff/Main.java

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[][] arr;
	static int result;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		arr = new int[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		result = 0;
		recur(0,0);
		System.out.println(result);	
	}
	
	static void recur(int idx, int cursum) {
		
		
		if (idx > N) return;
		
		if (idx == N) {
			result = Math.max(cursum, result);
			return;
		}
		
		// ����� �ϴ� ���
		recur(idx + arr[idx][0], cursum + arr[idx][1]);
		
		// ����� ���� �ʴ� ���
		recur(idx + 1, cursum);
	}
}
