package bfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) {
		HashMap<String, Integer> visited = new HashMap<String, Integer>(); // 방문했는지 아닌지 확인
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>(); // 노드에 인접 노드들 저장
		// key: String, value: ArrayList
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		scan.nextLine();
		String str = scan.nextLine();
		for (int i = 0; i < m; i++) {
			String s1 = scan.next();
			String s2 = scan.next();
			visited.put(s1, 0);
			visited.put(s2, 0);

			if (map.containsKey(s1)) {
				map.get(s1).add(s2);
			} else {
				map.put(s1, new ArrayList<String>());
				map.get(s1).add(s2);
			}
			if(map.containsKey(s2))
			{
				map.get(s2).add(s1);
			} else
			{
				map.put(s2, new ArrayList<String>());
				map.get(s2).add(s1);
			}
		}
		
		String sss = scan.next();
		
		Queue<String> q = new LinkedList<String>();
		q.add(sss);

		while (!q.isEmpty()) {
			if (visited.get(q.peek()).equals(0)) {
				System.out.print(q.peek() + " ");
				visited.put(q.peek(), 1);
			}
			if (!map.containsKey(q.peek())) {
				q.poll();
				continue;
			}

			Collections.sort(map.get(q.peek()));

			for (int i = 0; i < map.get(q.peek()).size(); i++) {
				q.add(map.get(q.peek()).get(i));
			}
			map.remove(q.peek());
			q.poll();
		}
	}
}
