package merge;

import java.util.ArrayList;
import java.util.Scanner;

public class Main1 {
	static int tries = 0;
	static int m;
	static String AD;

	// ar: 변경할 배열
	// l : 왼쪽 배열의 가장 앞의 인덱스
	// mid : 왼쪽 배열의 가장 마지막 인덱스
	// mid + 1: 오른쪽 배열의 가장 앞의 인덱스
	// r: 오른쪽 배열의 가장 뒤의 인덱스
	
	static void merge(String[] ar, int l, int mid, int r)
	{
		if (tries == m) return; // 허용된 실행 횟수를 모두 했다면 끝냄

		int i = l;
		int j = mid + 1;
		
		int index = 0; // 저장할 배!열!
		
		String[] tmp = new String[r - l + 1]; // 결과값을 저장할.
		
		
		if (AD.equals("A")) // 오름차순 정렬일 때.
		{
			// i와 j가 인덱스 범위 내일 때.
			while (i <= mid && j <= r)
			{
				
				if (ar[i].compareTo(ar[j]) < 0) // a[i]가 a[j]보다 앞에 위치할 때.
				{
					tmp[index++] = ar[i++];
				}
				else {
					tmp[index++] = ar[j++];
				}
			}
		}
		else {
			
			while (i <= mid && j <= r)
			{
				
				if (ar[i].compareTo(ar[j]) > 0) // a[i]가 a[j]보다 앞에 위치할 때.
				{
					tmp[index++] = ar[i++];
				}
				else {
					tmp[index++] = ar[j++];
				}
			}
		
		}
		
		// 남은 것들을... 저장....
		if(i <= mid)
		{
			for(; i <= mid; i++)
			{
				tmp[index++] = ar[i];
			}
		}
		else
		{
			for(; j <= r; j++)
			{
				tmp[index++] = ar[j];
			}
		}
		
		index = 0;
		
		for(int k = l; k <= r; k++)
		{
			ar[k] = tmp[index++];
		}
		
		tries++;
	}
	
	

	// l: 제일 앞의 인덱스 r: 마지막 인덱스 mid = 왼쪽 집합의 마지막 index.
	static void mergeSort(String[] ar, int l, int r)
	{
		if (l < r)
		{
			int mid = (r + l - 1) / 2;
			mergeSort(ar, l, mid);
			mergeSort(ar, mid + 1, r);
			merge(ar, l, mid, r);
		}
	}

	
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt(); // 원소 개수
		m = scan.nextInt();
		AD = scan.nextLine();
		AD = AD.trim();
		String line = scan.nextLine();
		String[] ar = line.split(" ");

		
		mergeSort(ar, 0, ar.length - 1);

		for (int i = 0; i < n; i++) {
			System.out.print(ar[i] + " ");
		}
		
	}

}
