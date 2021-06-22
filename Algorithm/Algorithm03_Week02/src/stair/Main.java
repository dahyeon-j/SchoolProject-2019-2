package stair;

import java.util.Scanner;

public class Main {
	
	static int ways(int st, int m)
	{
		
		int r = 0;
		
		if(st == 0)
		{
			return 1;
		}
		else
		{
			for(int i = 1; i <= m; i++)
			{
				if(i > st) {
					break;
				}
				else {
					r = r + ways(st - i, m);
				}
			}
		}
		
		return r;
	}
	
	
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int stairs = scan.nextInt();
		int max = scan.nextInt();
		System.out.println(ways(stairs, max));
		
	}
}
