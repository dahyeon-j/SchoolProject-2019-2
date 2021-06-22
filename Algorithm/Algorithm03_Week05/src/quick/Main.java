package quick;

import java.util.Scanner;

public class Main {
	static String AD;
	static int m;
	static void quickSort(String[] a, int lo, int hi)
	{
		if(lo < hi)
		{
			m--;
			int p = partition(a, lo, hi);
			if(m != 0) quickSort(a, lo, p - 1);
			if(m != 0) quickSort(a, p + 1, hi);
		}
	}
	
	static int partition(String a[], int lo, int hi)
	{
		String pivot = a[hi];
		int i = lo;
		if(AD.equals("A"))
		{
		for(int j = lo; j <= hi -1;j++)
		{
			if(a[j].compareTo(pivot) < 0)
			{
				String tmp = a[i];
				a[i] = a[j];
				a[j] = tmp;
				i = i+1;
			}
		}
		}
		else
		{
			for(int j = lo; j <= hi -1;j++)
			{
				if(a[j].compareTo(pivot) > 0)
				{
					String tmp = a[i];
					a[i] = a[j];
					a[j] = tmp;
					i = i+1;
				}
			}
		}
		String tmp = a[hi];
		a[hi] = a[i];
		a[i] = tmp;
		return i;
	}
	

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		m = scan.nextInt();
		AD = scan.nextLine();
		AD = AD.trim();
		String line = scan.nextLine();
		String[] a = line.split(" ");
		quickSort(a, 0, n-1);
		for(int i = 0; i < n; i++)
		{
			System.out.print(a[i] + " ");
		}
	}

}
