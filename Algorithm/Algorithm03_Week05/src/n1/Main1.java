package n1;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt(); // 단어의 수
		String s = scan.nextLine(); // A: 오름 차순, D 내림차순
		String[] ar = new String[n]; // 단어를 저장할 배열
		String str = scan.nextLine(); // 문자열을 입력 받음

		s = s.trim(); // 띄어쓰기를 자름.
		
		
		ar = str.split(" "); // 공백을 기준으로 단어를 분리
	
		Arrays.sort(ar); // 배열을 정렬
		
		if(s.equals("A"))
		{
			for(int i = 0; i < n; i++)
			{
				System.out.print(ar[i] + " ");
			}
		}
		else
		{
			for(int i = n-1; 0 <= i; i--)
			{
				System.out.print(ar[i] + " ");
			}
		}
		
		
		
	}

}
