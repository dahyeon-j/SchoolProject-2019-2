package controlflow;

import java.util.Scanner;

public class Main {
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		
		if(n % 2 == 0)
		{
			for(int i = 0; i < n; i++)
			{
				System.out.println("Hello, Contest!");
			}
			
		}
		else {
			for(int i = 0; i < n+1; i++)
			{
				System.out.println("Hello, Algorithm!");
			}
		}
	}
}
