package graph;

import java.util.HashMap;
import java.util.Scanner;

public class Main2 {
	
	public static void main(String[] args)
	{
		HashMap<String, HashMap<String, String>> map = new HashMap<String, HashMap<String,String>>();
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		scan.nextLine();
		String str = scan.nextLine();
		String[] ar = str.split(" ");
		for(int i = 0; i < m; i++)
		{
			String s1 = scan.next();
			String s2 = scan.next();
			
			if(map.containsKey(s1))
			{
				if(map.get(s1).containsKey(s2)) continue;
				map.get(s1).put(s2, s2);
			}
			else
			{
				map.put(s1, new HashMap<String, String>());
				map.get(s1).put(s2, s2);
			}
			
			if(map.containsKey(s2))
			{
				if(map.get(s2).containsKey(s1)) continue;
				map.get(s2).put(s1, s1);
			}
			else
			{
				map.put(s2, new HashMap<String, String>());
				map.get(s2).put(s1, s1);
			}	
		}
		String sss = scan.next();
		System.out.println(map.get(sss).size());
		
	}
}
