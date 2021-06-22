package gcd;

import java.util.Scanner;

public class Main {
	static int func(int a, int b)
	{
		if(a >= b)
		{
			if(a % b == 0)
			{
				return b;
			}
			else
			{
				return func(b, a % b);
			}
		}
		else
		{
			if(b % a == 0)
			{
				return a;
			}
			else
			{
				return func(a , b % a);
			}
		}
	}
	
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int n1 = scan.nextInt();
		int n2 = scan.nextInt();
		System.out.println(func(n1, n2));
	}
}
