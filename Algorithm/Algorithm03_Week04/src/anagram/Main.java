package anagram;

import java.util.Scanner;

public class Main {
	static boolean func(String s1, String s2)
	{
		s1 = s1.replace(" ", ""); // 공백 제거
		s1 = s1.toLowerCase(); // 소문자로
		s2 = s2.replace(" ", ""); // 공백 제거
		s2 = s2.toLowerCase(); // 소문자로
		if(s1.length() != s2.length()) return false; // 문자열의 길이가 다르면 fals를 반환
		
		int[] ar = new int[26]; // 문자의 개수를 세는 배열
		for(int i = 0; i < s1.length(); i++)
		{
			ar[s1.charAt(i) - 'a']++;
		}
		
		for(int i = 0; i < s2.length(); i++)
		{
			ar[s2.charAt(i) - 'a']--;
		}
		
		for(int i = 0; i < ar.length; i++)
		{
			if(ar[i] != 0) return false;
		}
		
		return true;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s1 = scan.next();
		String s2 = scan.next();
		
		if(func(s1, s2))
		{
			System.out.println("True");
		}
		else
		{
			System.out.println("False");
		}
	}

}
