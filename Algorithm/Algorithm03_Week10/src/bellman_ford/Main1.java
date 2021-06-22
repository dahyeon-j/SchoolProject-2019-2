package bellman_ford;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;


class Node {
	ArrayList<String> next;
	ArrayList<Integer> value;
	public Node() {
		next = new ArrayList<String>();
		value = new ArrayList<Integer>();
	}
}


public class Main1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		scan.nextLine();
		String[] nameOfNodes = scan.nextLine().split(" ");
		Arrays.sort(nameOfNodes);
		Hashtable<String, Node> table = new Hashtable<String, Node>();
		for (int i = 0; i < n; i++) {
			table.put(nameOfNodes[i], new Node());
		}
		
		for(int i = 0; i < m; i++) {
			String[] inputs = scan.nextLine().split(" ");
			table.get(inputs[0]).next.add(inputs[1]);
			table.get(inputs[0]).value.add(Integer.parseInt(inputs[2]));
		}
	
		String start = scan.nextLine();
		String end = scan.nextLine();
		
		String[] predecessor = new String[n];
		int[] distance = new int[n];
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		distance[Arrays.binarySearch(nameOfNodes, start)] = 0;
		
		boolean[] visited = new boolean[n];
		Arrays.fill(visited, false);
		Queue queue = new LinkedList<String>();
		queue.add(start);
		
		do {
			String key = (String) queue.poll();
			int index = Arrays.binarySearch(nameOfNodes, key);
			visited[index] = true;
			for(int i = 0; i < table.get(key).next.size(); i++) {
				int indexOfNext = Arrays.binarySearch(nameOfNodes, table.get(key).next.get(i));
				if(visited[indexOfNext] == false) {
					queue.add(table.get(key).next.get(i));
				}
				if(distance[index] + table.get(key).value.get(i) < distance[indexOfNext]) {
					distance[indexOfNext] = distance[index] + table.get(key).value.get(i);
					predecessor[indexOfNext] = key;
				}
			}
		} while(!queue.isEmpty());
		
		
		Arrays.fill(visited, false);
		
		queue = new LinkedList<String>();
		
		queue.add(start);
		
		boolean cycle = false;
		
		do {
			String key = (String) queue.poll();
			int index = Arrays.binarySearch(nameOfNodes, key);
			visited[index] = true;
			for(int i = 0; i < table.get(key).next.size(); i++) {
				int indexOfNext = Arrays.binarySearch(nameOfNodes, table.get(key).next.get(i));
				if(visited[indexOfNext] == false) {
					queue.add(table.get(key).next.get(i));
				}
				if(distance[index] + table.get(key).value.get(i) < distance[indexOfNext]) {
					cycle = true;
				}
			}
		} while(!queue.isEmpty() && !cycle);
		
		if(cycle) {
			System.out.println("Negative Cycle!");
		} else {
			Stack<String> sequence = new Stack<String>();
			sequence.add(end);
			while(predecessor[Arrays.binarySearch(nameOfNodes, sequence.peek())] != null) {
				sequence.add(predecessor[Arrays.binarySearch(nameOfNodes, sequence.peek())]);
			}
			while(!sequence.isEmpty()) {	
				System.out.print(sequence.pop() + " ");
			}
			System.out.println();
			System.out.println(distance[Arrays.binarySearch(nameOfNodes, end)]);
			
		}
		
	}

}
