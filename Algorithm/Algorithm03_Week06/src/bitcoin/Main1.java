package bitcoin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

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
			if (map.containsKey(s2)) {
				map.get(s2).add(s1);
			} else {
				map.put(s2, new ArrayList<String>());
				map.get(s2).add(s1);
			}
		}

		String sss = scan.next();

		Queue<String> q1 = new LinkedList<String>();
		Queue<String> q2 = new LinkedList<String>();
		
		q1.add(sss);
		visited.put(sss, 1);
		int tries = 0;
		
		while(!q1.isEmpty() || !q2.isEmpty())
		{
			if(!q1.isEmpty())
			{
				while(!q1.isEmpty())
				{
					String ts = q1.poll();
					for (int i = 0; i < map.get(ts).size(); i++) {
						if (visited.get(map.get(ts).get(i)).equals(0))
						{
							q2.add(map.get(ts).get(i));
							visited.replace(map.get(ts).get(i), 1);
						}
					}
				}
				if(!q2.isEmpty()) tries++;
			}
			else
			{
				while(!q2.isEmpty())
				{
					String ts = q2.poll();
					for (int i = 0; i < map.get(ts).size(); i++) {
						if (visited.get(map.get(ts).get(i)).equals(0))
						{
							q1.add(map.get(ts).get(i));
							visited.replace(map.get(ts).get(i), 1);
						}
					}
				}
				if(!q1.isEmpty()) tries++;
			}
		}



		System.out.println(tries);

	}

}
