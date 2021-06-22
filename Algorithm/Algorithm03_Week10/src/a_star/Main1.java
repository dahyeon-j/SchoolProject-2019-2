package a_star;

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
		Node[][] maze = new Node[row][column];
		boolean[][] added = new boolean[row][column];

		for(int i = 0; i < row; i++) {
			for(int j = 0; j < column; j++) {
				added[i][j] = false;
			}
		}
		Hashtable<Node, Node> cameFrom = new Hashtable<Node, Node>();
		
		for(int i = 0; i < row; i++) {
			String line = in.readLine();
			for(int j = 0; j < column; j++) {
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
		
		maze[start_x][start_y].gScore = 0;
		maze[start_x][start_y].fScore = h((double)start_x, (double)start_y);

		PriorityQueue<Node> queue = new PriorityQueue<Node>();
		queue.add(maze[start_x][start_y]);
		
		while(!queue.isEmpty()) {
			Node current = queue.poll();
			
			if(current.value == 'E') {
				current = cameFrom.get(current);
				do {
					current.value = 'P';
					current = cameFrom.get(current);
				} while(current.value !='S');
				for(int i = 0; i < row; i++) {
					for(int j = 0; j < column; j++) {
						System.out.print(maze[i][j].value);
					}
					System.out.println();
				}
				break;
			}
			
			for(int i = 0; i < 4; i++) {
				int tmp = current.gScore;
				
				Node neighbor = maze[current.x + n_x[i]][current.y + n_y[i]];
				
				if(neighbor.value == 'W') {
					continue;
				} else if(neighbor.value == 'B') {
					tmp += 3;
				} else if(neighbor.value == 'R') {
					tmp += 1;
				}
				
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
		
		if(!cameFrom.containsKey(maze[end_x][end_y])) {
			for(int i = 0; i < row; i++) {
				for(int j = 0; j < column; j++) {
					System.out.print(maze[i][j].value);
				}
				System.out.println();
			}
		}
	}
}
