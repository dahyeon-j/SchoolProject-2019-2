package change;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		
		int[] changes = new int[n]; // �ױ��� �����ϴ� �迭
		
		for(int i = 0; i < n; i++) {
			changes[i] = scan.nextInt();
		}
		
		int m = scan.nextInt(); // �ܾ�
		
		
		int[] dp = new int[m+1]; // dp ������� ������ �迭 : �ε��� == ��, �� == �ּ� ���� ��
		
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
