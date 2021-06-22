package position;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;



public class Main1 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int k = Integer.parseInt(in.readLine());
		
		
		// 결과 값을 저장
		Hashtable<String, String> table = new Hashtable<String, String>();
		
		
		
		// 포지션 선호 순위를 저장
		//Hashtable<String, Hashtable<String, Integer>> inputs = new Hashtable<String, Hashtable<String,Integer>>();
		// 첫번째 key : 이름
		// 두번 째 key: 남은 것의 수로 선호도를 알 수 있다. 남은게 크면 클 수록 선호도가 큰 것. 그럼 Queue를 사용
		Hashtable<String, Queue<String>> inputs1 = new Hashtable<String, Queue<String>>();		
		String[] name = new String[k];
		for(int i = 0; i < k; i++) {
			String[] line = in.readLine().split(" ");
			inputs1.put(line[0], new LinkedList<String>());
			name[i] = line[0];
			for(int j = 1; j <= k; j++) {
				inputs1.get(line[0]).add(line[j]);
			}
		}
		
		// key: 자리
		// 이름: position -> 사람 이름 -> 선호
		Hashtable<String, Hashtable<String, Integer>> inputs2 = new Hashtable<String, Hashtable<String,Integer>>();		
		String[] pos = new String[k];
		for(int i = 0; i < k; i++) {
			String[] line = in.readLine().split(" ");
			inputs2.put(line[0], new Hashtable<String, Integer>());
			pos[i] = line[0];
			for(int j = 1; j <=k; j++) {
				inputs2.get(line[0]).put(line[j], j);
			}
		}
		
		String find = in.readLine();
		
		Arrays.sort(name);
		boolean remain[] = new boolean[k];
		Arrays.fill(remain, true);
		
		int cnt = k;
		
		
		while(cnt != 0) {
			for(int i = 0; i <k; i++) {
				if(remain[i] == true) {
					String position = inputs1.get(name[i]).poll(); // 가장 원하는 position
					// table에 key가 있으면 비교.
					if(table.containsKey(position)) {
						String e = table.get(position); // 비교 대상의 이름
						if(inputs2.get(position).get(name[i]) < inputs2.get(position).get(e)) {
							table.put(position, name[i]);
							remain[i] = false;
							remain[Arrays.binarySearch(name, e)] = true;
						}
					} else {
						table.put(position, name[i]);
						remain[i] = false;
						cnt--;
					}
				}
			}
		}
		
		for(int i = 0; i < k; i++) {
			if(table.get(pos[i]).equals(find)) {
				System.out.println(pos[i]);
				break;
			}
		}
		
		
	}

}
