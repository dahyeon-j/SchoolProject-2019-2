package serverlog;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.PriorityQueue;

class Server implements Comparable<Server> {

	String name;
	Date date;
	
	
	public Server(String name, String d) throws Exception {
		this.name = name;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
		this.date = df.parse(d);
	}
	
	
	public int compareTo(Server o) {
		if(o.date.compareTo(date) < 0) {
			return -1;
		}
		
		return 1;
	}
	
}

public class Main1 {
	
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = in.readLine().split(" ");
		int n = Integer.parseInt(inputs[0]);
		int m = Integer.parseInt(inputs[1]);
		
		String line = in.readLine();
		
		PriorityQueue<Server> queue = new PriorityQueue<Server>();
		
		for(int i = 0; i < m; i++) {
			inputs = in.readLine().split(" ");
			queue.add(new Server(inputs[0], inputs[1]));
		}
		
		
		String s = in.readLine();
		
		Server ss = new Server("tmp", s);
				
		
		for(int i = 0; i < m; i++) {
			if((queue.peek().date).compareTo(ss.date) < 0) {
				System.out.println(queue.peek().name);
				break;
			}
			queue.poll();
		}
		
		if(queue.isEmpty()) {
			System.out.println("Internal");
		}
		
	}
}
