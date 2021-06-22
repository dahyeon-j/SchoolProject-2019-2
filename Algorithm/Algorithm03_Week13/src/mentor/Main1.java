package mentor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main1 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(in.readLine());

		String[] name = new String[n];

		int[] year = new int[n];

		for (int i = 0; i < n; i++) {
			String[] input = in.readLine().split(" ");
			name[i] = input[0];
			year[i] = Integer.parseInt(input[1]);
		}

		int[][] c = new int[2 * n + 2][2 * n + 2];
		int[][] f = new int[2 * n + 2][2 * n + 2];

		int src = 2 * n;
		int dest = 2 * n + 1;

		// 시작 부터 끝 노드까지
		for (int i = 0; i < n; i++) {
			c[src][2 * i] = 1;
		}
		
		// 끝 노드에 들거 가는거
		for (int i = 0; i < n; i++) {
			c[2 * i + 1][dest] = 1;
		}
		
		// 가운데 엣지
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j)
					continue;
				if (year[i] < year[j]) {
					c[2 * i][2 * j + 1] = 1;
				}
			}
		}
		
		/*
		for(int i = 0; i <= dest; i++) {
			for(int j = 0; j <= dest; j++) {
				System.out.print(c[i][j]);
			}
			System.out.println();
		}
		*/

		int total = 0;

		while (true) {
			
			int prev[] = new int[dest + 1];
			Arrays.fill(prev, -1);

			Queue<Integer> queue = new LinkedList<Integer>();

			queue.add(src); // 시작 노드를 추가.
			
			while (!queue.isEmpty()) {
				int cur = queue.poll();
				if (cur == dest)
					break;
				
				for (int i = 0; i <= dest; i++) {
					if(cur == i) continue;
					if(prev[i] != -1) continue;
					if(c[cur][i] == f[cur][i]) continue; // 1밖에 안 커지니까.	
					prev[i] = cur;
					
					queue.add(i);
				}
				
			}
			
			if(prev[dest] == -1) break;
			
			for(int i = dest; i != src; i = prev[i]) {
				f[prev[i]][i] += 1;
				f[i][prev[i]] -= 1;
			}
			
			total++;
		}
		
		
		System.out.println(n - total);

	}

}
