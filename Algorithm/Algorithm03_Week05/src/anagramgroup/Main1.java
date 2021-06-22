package anagramgroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Main1 {

	static void solution(String[] a) {
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		for (int i = 0; i < a.length; i++) {
			char[] c = a[i].toCharArray();
			Arrays.sort(c);
			String k = String.valueOf(c);
			if (map.containsKey(k)) {
				map.get(k).add(a[i]);
			} else {
				map.put(k, new ArrayList<String>());
				map.get(k).add(a[i]);
			}
		}

		for (int i = 0; i < a.length; i++)
		{
			char[] c = a[i].toCharArray();
			Arrays.sort(c);
			String k = String.copyValueOf(c);
			if(k.length() == 0) continue;
			if (!map.containsKey(k)) {
				continue;
			}
			Collections.sort(map.get(k));
			for (int j = 0; j < map.get(k).size(); j++) {
				System.out.print(map.get(k).get(j) + " ");
			}
			System.out.println();
			map.remove(k);
		}
		
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		str = str.toLowerCase();
		str = str.trim();
		String[] a = str.split(" ");
		Arrays.sort(a);
		solution(a);
	}
}
