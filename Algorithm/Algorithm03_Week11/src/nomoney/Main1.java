package nomoney;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Hashtable;
import java.util.PriorityQueue;

class Node implements Comparable<Node>{
	char value;
	int gScore;
	double fScore;
	int x;
	int y;
	public Node(char value, int gScore, double fSCore, int x, int y) {
		this.value = value;
		this.gScore = gScore;
		this.fScore = fSCore;
		this.x = x;
		this.y = y;
	}
	@Override
	public int compareTo(Node node) {
		if(fScore > node.fScore) {
			return 1;
		}
		return -1;
	}
}

public class Main1 {
	static int start_x = 0, start_y = 0, end_x, end_y;
	static int[] n_x = {-1, 0, 1, 0};
	static int[] n_y = {0, 1, 0, -1};
	
	static double h(double x1, double y1) {
		return Math.sqrt(Math.pow(x1 - end_x, 2) + Math.pow(y1 - end_y, 2));
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = in.readLine().split(" ");
		int row = Integer.parseInt(inputs[0]);
		int column = Integer.parseInt(inputs[1]);
		int money = Integer.parseInt(inputs[2]);
		
		// 미로
		Node[][] maze = new Node[row][column];
		// 더해졌는지 아닌지 	.
		boolean[][] added = new boolean[row][column];

		// added 초기화
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < column; j++) {
				added[i][j] = false;
			}
		}
		// 전의 노드가 어디인지
		Hashtable<Node, Node> cameFrom = new Hashtable<Node, Node>();
		
		// 노드들을 입력받음.
		for(int i = 0; i < row; i++) {
			String line = in.readLine();
			for(int j = 0; j < column; j++) {
				// charAt이 value
				maze[i][j] = new Node(line.charAt(j), Integer.MAX_VALUE, Double.MAX_VALUE, i, j);
				if(maze[i][j].value == 'S') {
					start_x = i;
					start_y = j;
				} else if(maze[i][j].value == 'E'){
					end_x = i;
					end_y = j;
				}
			}
		}
		
		// gScore은 돈
		maze[start_x][start_y].gScore = 0;
		
		// fScore은 휴리스틱
		maze[start_x][start_y].fScore = h((double)start_x, (double)start_y);
		
		// Node들을 저장할 queue
		PriorityQueue<Node> queue = new PriorityQueue<Node>();
		queue.add(maze[start_x][start_y]);
		
		
		
		// 큐가 비어있지 않은 동안.
		while(!queue.isEmpty()) {
			// 현재의 노드를 뺀다.
			Node current = queue.poll();
			
			if(current.value == 'E') break;
			
			for(int i = 0; i < 4; i++) {
				int tmp = current.gScore;

				// 이웃노드
				Node neighbor = maze[current.x + n_x[i]][current.y + n_y[i]];
				
				if(neighbor.value == 'W') {
					continue;
				} else if('0' <= neighbor.value&& neighbor.value <='9') {
					tmp += (neighbor.value - '0');
				}
				
				// 현재 계산한 값이 이웃보다 작으면.
				if(tmp < neighbor.gScore) {
					cameFrom.put(neighbor , current);
					neighbor.gScore = tmp;
					neighbor.fScore = tmp + h((double)(neighbor.x), (double)(neighbor.y));
					if(added[neighbor.x][neighbor.y] == false) {
						queue.add(maze[neighbor.x][neighbor.y]);
						added[neighbor.x][neighbor.y] = true;
					}
				}
			}
		}
		
		if(0 <= money - maze[end_x][end_y].gScore) {
			System.out.println(money - maze[end_x][end_y].gScore);
		} else {
			System.out.println("Not enough money!");
		}
		
	}
}
