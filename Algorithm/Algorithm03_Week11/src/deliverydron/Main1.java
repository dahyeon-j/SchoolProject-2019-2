package deliverydron;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node {
	String next;
	int value;
	public Node(String next, int value) {
		this.next = next;
		this.value = value;
	}
}

public class Main1 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] input = in.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		
		String[] nodeName = in.readLine().split(" ");
		Arrays.sort(nodeName);
				
		Hashtable<String, Integer> node = new Hashtable<String, Integer>();
		for(int i = 0; i < n; i++) {
			input = in.readLine().split(" ");
			node.put(input[0], Integer.parseInt(input[1]));
		}
		
		Hashtable<String, ArrayList<Node>> graph = new Hashtable<String, ArrayList<Node>>();
		
		for(int i = 0; i < n; i++) {
			graph.put(nodeName[i], new ArrayList<Node>());
		}
		
		for(int i = 0; i < m; i++) {
			input = in.readLine().split(" ");
			graph.get(input[0]).add(new Node(input[1], Integer.parseInt(input[2])));
			graph.get(input[1]).add(new Node(input[0], Integer.parseInt(input[2])));
		}
		
		String start = in.readLine();
		String dest = in.readLine();
		
		boolean[] visited = new boolean[n];
		int[] distance = new int[n];
		Arrays.fill(distance, Integer.MAX_VALUE);
		String[] prev = new String[n];
		
		
		Queue queue = new LinkedList<String>();
		queue.add(start);
		distance[Arrays.binarySearch(nodeName, start)] = 0;
		visited[Arrays.binarySearch(nodeName, start)] = true;
		while(!queue.isEmpty()) {
			// current: 현재 위치
			String current = (String) queue.poll();
			for(int i = 0; i < graph.get(current).size(); i++) {
				// 다음 노드의 정보
				Node tmp = graph.get(current).get(i);
				// tmpIndex: 다음 노드의 인덱스
				int tmpIndex = Arrays.binarySearch(nodeName, tmp.next);
				// 방문하지 않은 노드는 추가
				if(visited[tmpIndex] == false) {
					queue.add(tmp.next);
					visited[tmpIndex] = true;
				}
				
				// 거리를 변경
				if(distance[Arrays.binarySearch(nodeName, tmp.next)] > tmp.value + distance[Arrays.binarySearch(nodeName, current)]) {
					distance[Arrays.binarySearch(nodeName, graph.get(current).get(i).next)] = graph.get(current).get(i).value + distance[Arrays.binarySearch(nodeName, current)] + node.get(graph.get(current).get(i).next);
					prev[Arrays.binarySearch(nodeName, graph.get(current).get(i).next)] = current;
				}	
			}
			
		}
		
		Stack stack = new Stack<String>();
		System.out.print(start + " ");
		for(String i = dest; i != start; i = prev[Arrays.binarySearch(nodeName, i)]) {
			stack.push(i);
		}
		while(!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
		System.out.println();
		System.out.println(distance[Arrays.binarySearch(nodeName, dest)] - node.get(dest));

	}

}
