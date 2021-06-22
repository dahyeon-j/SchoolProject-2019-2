package palindrome;

import java.util.Scanner;

public class Main {
	
	static int func(String str)
	{
		int[][] ar = new int[str.length()][str.length()];
		for(int i = 0; i < ar.length; i++) 
		{
			ar[i][i] = 1;
		}
		
		for(int i = 1; i < str.length(); i++)
		{
			if(str.charAt(i-1) == str.charAt(i))
			{
				ar[i-1][i] = 1;
			}
		}
		
		for(int i = 2; i < str.length(); i++)
		{
			for(int j = i; j < str.length(); j++)
			{
				if(ar[j-i+1][j - 1] == 1 && str.charAt(j) == str.charAt(j-i))
				{
					ar[j-i][j] = 1;
				}
			}
		}
		
		for(int i = str.length()-1; 0 <= i; i--)
		{
			for(int j = str.length() - 1; 0 <= j && i <= j; j--)
			{
				if(ar[j-i][j] == 1) return i + 1;
			}
		}
		
		
		return 1;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		str = str.replace(" ", "");
		str = str.toLowerCase();
		System.out.println(func(str));
	}

}
