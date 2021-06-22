package dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
	String name;
	int value;
	public Node(String name, int value) {
		this.name = name;
		this.value = value;
	}
}

public class Main1 {	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		scan.nextLine();
		
		String[] nodes = scan.nextLine().split(" ");
		
		Arrays.sort(nodes);
		
		int[] distance = new int[n];
		boolean[] visited = new boolean[n];
		Arrays.fill(visited, false);
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		String[] prev = new String[n];
		
		ArrayList<ArrayList<Node>> next = new ArrayList<ArrayList<Node>>();
		
		for(int i = 0; i < n; i++) {
			next.add(new ArrayList<Node>());
		}
		
		for(int i = 0; i < m; i++) {
			String[] tmp = scan.nextLine().split(" ");
			
			next.get(Arrays.binarySearch(nodes, tmp[0])).add(new Node(tmp[1], Integer.parseInt(tmp[2])));
		}
		
		String start = scan.nextLine();
		String end = scan.nextLine();
		
		Queue queue = new LinkedList<Node>();
		
		queue.add(new Node(start, 0));
		
		distance[Arrays.binarySearch(nodes, start)] = 0;
		prev[Arrays.binarySearch(nodes, start)] = start;
		
		
		do {
			Node key = (Node) queue.poll();
			String keyName = key.name;
			int keyIndex = Arrays.binarySearch(nodes, keyName);
			if(visited[Arrays.binarySearch(nodes, keyName)] == true) continue;
			visited[Arrays.binarySearch(nodes, keyName)] = true;
			
			
			for(int i = 0; i < next.get(keyIndex).size(); i++) {
				queue.add(next.get(keyIndex).get(i));
			}
			
			for(int i = 0; i < next.get(keyIndex).size(); i++) {
				int index = Arrays.binarySearch(nodes, next.get(keyIndex).get(i).name);
				
				if(distance[keyIndex] + next.get(keyIndex).get(i).value < distance[index]) {
					distance[index] = distance[keyIndex] + next.get(keyIndex).get(i).value;
					prev[index] = keyName;
				}
			}
			
		} while(!queue.isEmpty());
		
		
		ArrayList<String> way = new ArrayList<String>();
		
		way.add(end);
		
		while(!start.equals(way.get(way.size() - 1))) {
			way.add(prev[Arrays.binarySearch(nodes, way.get(way.size()-1))]);
		}
		
		for(int i = way.size() - 1; 0 <= i; i--) {
			System.out.print(way.get(i) + " ");
		}
		
		System.out.println();
		
		System.out.println(distance[Arrays.binarySearch(nodes, end)]);
	}

}
