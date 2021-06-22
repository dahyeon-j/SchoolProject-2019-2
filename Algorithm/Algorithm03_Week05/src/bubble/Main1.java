package bubble;

import java.util.Scanner;

public class Main1 {

	static void bubbleSort(int tr, String str, String[] ar) {

		if (str.equals("A")) {
			for(int i = 0; i < tr; i++)
			{
				for(int j = 0; j < ar.length - 1; j++)
				{
					if(ar[j].compareTo(ar[j+1]) > 0)
					{
						String tmp = ar[j];
						ar[j] = ar[j+1];
						ar[j+1] = tmp;
						
					}
				}
			}
		}
		else
		{
			for(int i = 0; i < tr; i++)
			{
				for(int j = 0; j < ar.length - 1; j++)
				{
					if(ar[j].compareTo(ar[j+1]) < 0)
					{
						String tmp = ar[j];
						ar[j] = ar[j+1];
						ar[j+1] = tmp;
						
					}
				}
			}
		}


		for (int i = 0; i < ar.length; i++)
		{
			System.out.print(ar[i] + " ");
		}
	}



	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int tr = scan.nextInt();
		String str = scan.nextLine();
		str = str.trim();

		String line = scan.nextLine();

		String[] ar = line.split(" ");

		bubbleSort(tr, str, ar);

	}

}
