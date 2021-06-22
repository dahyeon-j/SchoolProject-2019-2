package change;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		
		int[] changes = new int[n]; // 액권을 저장하는 배열
		
		for(int i = 0; i < n; i++) {
			changes[i] = scan.nextInt();
		}
		
		int m = scan.nextInt(); // 잔액
		
		
		int[] dp = new int[m+1]; // dp 결과값을 저장한 배열 : 인덱스 == 돈, 값 == 최소 동전 수
		
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		dp[0] = 0;
		
		for(int i = 0; i <= m; i++) {
			for(int j = 0; j < n; j++) {
				if(i + changes[j] > m ) continue;
				if(dp[i] + 1 < dp[i+changes[j]]) {
					dp[i+changes[j]] = dp[i] + 1;
				}
			}
		}
		
		System.out.println(dp[m]);
	}

}
