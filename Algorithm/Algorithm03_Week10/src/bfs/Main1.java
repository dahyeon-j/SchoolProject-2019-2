package bfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		scan.nextLine();
		String node[] = scan.nextLine().split(" ");
		Hashtable<String, ArrayList<String>> table = new Hashtable<String, ArrayList<String>>();
		
		
		for(int i = 0; i < n; i++) {
			table.put(node[i], new ArrayList<String>());
		}
		
		for(int i = 0; i < m; i++) {

			String[] tmp = scan.nextLine().split(" ");
			table.get(tmp[0]).add(tmp[1]);
		}
		
		String start = scan.nextLine();
		
		Queue queue = new LinkedList<String>();
		queue.add(start);
		
		do {
			String key = (String)queue.poll();
			if(table.containsKey(key)) {
				System.out.print(key + " ");
				Collections.sort(table.get(key));
			} else {
				continue;
			}
			for(int i = 0; i < table.get(key).size();i++) {
				queue.add(table.get(key).get(i));
			}
			table.remove(key);
		} while(!queue.isEmpty());

	}

}
