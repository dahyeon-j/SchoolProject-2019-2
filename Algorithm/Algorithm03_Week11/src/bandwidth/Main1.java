package bandwidth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main1 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] inputs = in.readLine().split(" ");
		int n = Integer.parseInt(inputs[0]);
		int m = Integer.parseInt(inputs[1]);
		int size = Integer.parseInt(inputs[2]);
		
		String[] nodeName = in.readLine().split(" ");
		Arrays.sort(nodeName);
		
		int[][] c = new int[n][n];
		int[][] f = new int[n][n];
		
		for(int i = 0; i < m; i++) {
			inputs = in.readLine().split(" ");
			int index1 = Arrays.binarySearch(nodeName, inputs[0]);
			int index2 = Arrays.binarySearch(nodeName, inputs[1]);
			c[index1][index2] = c[index2][index1] = Integer.parseInt(inputs[2]);
		}
		
		String start = in.readLine();
		int startIndex = Arrays.binarySearch(nodeName, start);
		String dest = in.readLine();
		int destIndex = Arrays.binarySearch(nodeName, dest);
		
		int max = 0;
		while(true) {
			int prev[] = new int[n];
			Arrays.fill(prev, -1);
			
			Queue<Integer> queue = new LinkedList<Integer>();
			queue.add(startIndex);
			
			while(!queue.isEmpty()) {
				int current = queue.poll();
				if(current == destIndex) break;
				
				for(int i = 0; i < n; i++) {
					if(current == i) continue;
					if(prev[i] > -1) continue; // 이미 탐색을 했었다면
					if(f[current][i] < c[current][i]) {
						prev[i] = current;
						queue.add(i);
					}
				}
			}
			
			if(prev[destIndex] == -1) break;
			
			int min = Integer.MAX_VALUE;
			for(int i = destIndex; i != startIndex; i = prev[i]) min = Math.min(min, c[prev[i]][i] - f[prev[i]][i]);
			for(int i = destIndex; i != startIndex; i = prev[i]) f[prev[i]][i] += min;
			for(int i = destIndex; i != startIndex; i = prev[i]) f[i][prev[i]] -= min;
			max += min;
			
		}
		
		
		System.out.println((int)Math.ceil((double)size/max));
	}

}
