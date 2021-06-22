package kakao;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String input = scan.nextLine();
	
		int[] score = new int[3]; // 점수를 저장
		int dn = 0; // 다음에 2배를 할지 말지 선택
		int index = 0; // score 배열의 index
		int last = 0; // 마지막에 자른 index -> 정수가 10까지 있기 때문.
		for(int i = 0; i < input.length(); i++)
		{
			char c = input.charAt(i);
			if(c == 'S')
			{
				score[index] = Integer.parseInt(input.substring(last, i));
				if(dn == 1)
				{
					score[index] *= 2;
					dn = 0;
				}
				index++;
				last = i+1;
			}
			else if(c == 'D')
			{
				score[index] = (int) Math.pow(Integer.parseInt(input.substring(last, i)), 2);

				if(dn == 1)
				{
					score[index] *= 2;
					dn = 0;
				}
				last = i+1;
				index++;
			}
			else if(c == 'T')
			{
				score[index] = (int) Math.pow(Integer.parseInt(input.substring(last, i)), 3);
				if(dn == 1)
				{
					score[index] *= 2;
					dn = 0;
				}
				index++;
				last = i+1;
			}
			else if(c == '*')
			{
				dn = 1;
				score[index-1] *= 2;
				last++;
			}
			else if(c == '#')
			{
				score[index-1] *= -1;
				last++;
			}
		}
		
		int result = 0;
		for(int i = 0; i < 3; i++)
		{
			result += score[i];
		}
		
		System.out.println(result);
		
	}
}
