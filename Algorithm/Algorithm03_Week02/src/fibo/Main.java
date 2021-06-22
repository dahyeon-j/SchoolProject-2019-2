package fibo;

import java.util.Scanner;

public class Main {
	static int fib(int n)
	{
		if(n == 0)
		{
			return 0;
		}
		if(n == 1)
		{
			return 1;
		}
		return fib(n-1) + fib(n-2);
	}
	
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		System.out.println(fib(a));
	}
}
