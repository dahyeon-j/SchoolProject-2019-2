package change;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	
	static int c(ArrayList<Integer> list, int money)
	{
		
		for(int i = 0; i < list.size(); i++)
		{
			if(money == list.get(i)) return 1;
		}
		
		int[] results = new int[list.size()];
		
		for(int i = 0; i < list.size() ;i++)
		{
			ArrayList<Integer> li = new ArrayList<Integer>();
			for(int j = 0; j < list.size(); j++)
			{
				if(list.get(j) <= money - list.get(i)) {
					li.add(list.get(j));
				}
			}
			if(li.size() != 0) results[i] = 1 + c(li, money - list.get(i));	
		}
		
		Arrays.sort(results);
		
		return results[0];
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] changes = new int[n];
		
		for(int i = 0; i < n; i++)
		{
			changes[i] = scan.nextInt();
		}
		
		int m = scan.nextInt();
		
		ArrayList<Integer> tmp = new ArrayList<>();
		
		for(int i = 0; i < changes.length; i++)
		{
			if(changes[i] <= m)
			{
				tmp.add(changes[i]);
			}
		}
		
		System.out.println(c(tmp, m));

	}
}
