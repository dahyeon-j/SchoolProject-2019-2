package drill;

import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int r = scan.nextInt();
		int c = scan.nextInt();
		
		int[][] map = new int[r][c]; // �� �������� �ִ밪.
		int[][] dp = new int[r][c]; // ������ �ִ밪�� ������ �迭
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				map[i][j] = scan.nextInt();
			}
		}
		
		// dp�� ù��° ���� �ʱ�ȭ.
		for(int i = 0; i < c; i++) {
			dp[0][i] = map[0][i];
		}
		
		for(int i = 1; i < r; i++) {
			for(int j = 0; j < c; j++) {
				for(int k = -1; k <= 1; k++) {
					
					if(j + k < 0 || c <= j + k ) {
						continue;
					}
					
					dp[i][j] = Math.max(map[i][j] + dp[i-1][j+k], dp[i][j]);
				}
			}
		}
		
		int answer = dp[r-1][0];
		for(int i = 1; i < c; i++) {
			answer = Math.max(answer, dp[r-1][i]);
		}
		
		System.out.println(answer);
	}

}
