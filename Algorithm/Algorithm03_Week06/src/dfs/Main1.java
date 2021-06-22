package dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Main1 {

	public static void main(String[] args) {
		HashMap<String, Integer> visited = new HashMap<String, Integer>();
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
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
		
		Stack<String> st = new Stack<String>();
		st.add(sss);

		while (!st.isEmpty()) {
			String ps = st.pop();
			
			if (visited.get(ps).equals(0)) {
				System.out.print(ps + " ");
				visited.put(ps, 1);
			}
			
			
			if (!map.containsKey(ps)) {
				continue;
			}

			Collections.sort(map.get(ps));

			for (int i = map.get(ps).size() -1; 0 <= i; i--) {
				st.add(map.get(ps).get(i));
			}
			
			map.remove(ps);
		}
	}
}
