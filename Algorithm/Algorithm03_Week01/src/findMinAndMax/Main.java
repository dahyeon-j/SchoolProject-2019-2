package findMinAndMax;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k = scan.nextInt();
		int i = scan.nextInt();
		
		int[] ar = new int[n];
		
		for(int j = 0; j < n; j++)
		{
			ar[j] = scan.nextInt();
		}
		
		Arrays.sort(ar);
		
		int r = ar[n - i] -  ar[k-1];
		r =  r > 0? r : -r;
		System.out.println(r);
	}
}
