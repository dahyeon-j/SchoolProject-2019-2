package knapsack;

import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int K = scan.nextInt();
		int N = scan.nextInt();
		int[][] inputs = new int[2][N+1];
		for(int i = 0; i < 2; i++) {
			for(int j = 1; j <= N; j++) {
				inputs[i][j] = scan.nextInt();
			}
		}
		
		int[][] dp = new int[N+1][K+1];
		
		for(int i = 1; i <= N; i++) {
			int W = inputs[0][i];
			int V = inputs[1][i];
			for(int j = 1; j <= K; j++) {
				if(W <= j) {
					if(V + dp[i-1][j-W] > dp[i-1][j]) {
						dp[i][j] = V + dp[i-1][j-W];
					} else {
						dp[i][j] = dp[i-1][j];
					}
				}
				else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		
		System.out.println(dp[N][K]);
		
	}

}
