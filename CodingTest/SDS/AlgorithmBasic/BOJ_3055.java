// BFS와 DFS의 차이는, DFS는 동시에 움직이는 것을 처리할 수 없음.
// 물, 고슴도치 움직임 -> BFS 사용해야..

package Day01.P3055;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
//	조이스틱 만든다고 생각. 좌, 우, 위, 아래.
	static int[] mx = {-1, 1, 0, 0};
//	y축 조이스틱.
	static int[] my = {0, 0, -1, 1};
	
	static int R, C;
	static char[][] map;
	
	static Queue<Point> queue;
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("/Users/hamin/eclipse-workspace/SamsungSDS/src/Day01/P3055/input.txt"));
		
		Scanner sc = new Scanner(System.in);
		
		R = sc.nextInt();
		C = sc.nextInt();
		
		System.out.println(R + ", " + C);
		
		map = new char[R][C];
		queue = new LinkedList<>();
        
		for (int r = 0; r < R; r++) {
			String line = sc.next();
			for (int c = 0; c < C; c++) {
				map[r][c] = line.charAt(c);
			}
		}
		
		for (int r = 0; r < R; r++) {
			System.out.println(Arrays.toString(map[r]));
		}
		
		while(!queue.isEmpty()) {
//			1. 큐애서 꺼내옴.
			Point p = queue.poll();
//			2. 목적지인가?		if (p == 'D')
			
//			3. 갈 수 있는 곳을 순회.		for (좌, 우, 위, 아래)
			int y = 0;
			int x = 0;
			for (int i = 0; i < 4; i++) {
				int ty = y + my[i];
				int tx = x + mx[i];
//				4. 		갈 수 있는가? 		if( 맵을 벗어나지 않고, x가 아니고, * 아니고)
				
//				5. 			체크인.		dp[r][c] = time
//				6. 			큐에 넣음.		queue.add(next)
			}
		}
		
//		Point p = new Point(0, 0, '*');
//		System.out.println(p);
		
//		간단한 queue 사용법.
//		queue.add(p);
//		System.out.println(queue);
//		peek은 한번 보는.
//		System.out.println(queue.peek());
//		System.out.println(queue);
//		poll은 빼버리는.
//		System.out.println(queue.poll());
//		System.out.println(queue);
	}
}

// 점이라는 클래스.
class Point{
	int y;
	int x;
	char type;
	
	public Point(int y, int x, char type) {
		super();
		this.y = y;
		this.x = x;
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "[y=" + y + ", x= " + x + ", type=" + type + "]";
	}
}
