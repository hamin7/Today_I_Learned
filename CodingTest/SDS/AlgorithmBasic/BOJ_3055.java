// BFS와 DFS의 차이는, DFS는 동시에 움직이는 것을 처리할 수 없음.
// 물, 고슴도치 움직임 -> BFS 사용해야..

package Day01.P3055;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
//	조이스틱 만든다고 생각. 좌, 우, 위, 아래.
	static int[] mx = {-1, 1, 0, 0};
//	y축 조이스틱.
	static int[] my = {0, 0, -1, 1};
	
	static int R, C;
	static char[][] map;
	// 고슴도치가 간 곳을 dp에 저장할 것이다.
	// boolean형이 아니라 int형이라 몇 번째로 지나갔는지를 의미.
	static int[][] dp;
	
	static Queue<Point> queue;
	static boolean foundAnswer;
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("/Users/hamin/eclipse-workspace/SamsungSDS/src/Day01/P3055/input.txt"));
		
		Scanner sc = new Scanner(System.in);
		
		R = sc.nextInt();
		C = sc.nextInt();
		
		// System.out.println(R + ", " + C);
		
		map = new char[R][C];
		dp = new int[R][C];
		queue = new LinkedList<>();
		
		List<Point> waterList = new ArrayList<>();
		for (int r = 0; r < R; r++) {
			String line = sc.next();
			for (int c = 0; c < C; c++) {
				map[r][c] = line.charAt(c);
				// 시작점인가 봐야 함.
				if (map[r][c] == 'S') {
					// 시작점이면 queue에 넣어줘야.
					queue.add(new Point(r, c, 'S'));
				} else if (map[r][c] == '*') {
					waterList.add(new Point(r, c, '*'));
				}
			}
		}
		// waterList가 뭉덩이로 들어감.
		queue.addAll(waterList);
		
		// for (int r = 0; r < R; r++) {
		// 	System.out.println(Arrays.toString(map[r]));
		// }
		
		// System.out.println(queue);

		while(!queue.isEmpty()) {
//			1. 큐애서 꺼내옴.
			Point p = queue.poll();
//			2. 목적지인가?		if (p == 'D')
			if (p.type == 'D') {
				// 목적지 도착.
				// 현재 자리까지 오는데 걸린 시간 출력.
				System.out.println(dp[p.y][p.x]);
				foundAnswer = true;
				break;
			}
//			3. 갈 수 있는 곳을 순회.		for (좌, 우, 위, 아래)
			for (int i = 0; i < 4; i++) {
				int ty = p.y + my[i];
				int tx = p.x + mx[i];
				// 4. 		갈 수 있는가?  if( 맵을 벗어나지 않고, x가 아니고, * 아니고(현재 물이 아니고 다음턴에도 물이 아닌))
				// 지도에서 벗어나지 않는 것 체크
				if ( 0 <= ty && ty < R && 0 <= tx && tx < C) {
					// 벗어나지 않는 좌표인데 이게 .이냐 S냐 *이냐에 따라 동작 달라짐.
					if (p.type == '.' || p.type == 'S') {
						// 내가 간적이 없고, 안전한 자리면.
						if (dp[ty][tx] == 0 && checkSafe(ty, tx)) {
							// 5. 			체크인.		dp[r][c] = time
							// 내가 현재까지 오개 된 자리 + 1.
							dp[ty][tx] = dp[p.y][p.x] + 1;
							// 6. 			큐에 넣음.		queue.add(next)
							queue.add(new Point(ty, tx, map[ty][tx]));
						}
					} else if (p.type == '*' && map[ty][tx] == '.') {
						// 6. 			큐에 넣음.		queue.add(next)
						queue.add(new Point(ty, tx, '*'));
						map[ty][tx] = '*';
					}
				}
			}
		}

		if (foundAnswer == false) {
			System.out.println("KAKTUS");
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
		
	// x가 아니고, * 아니고, *에 인접한 .도 아닌지 체크.
	static boolean checkSafe(int y, int x) {
		if (map[y][x] == 'D') {
			return true;
		} else if (map[y][x] == '.') {
			// 다음 점이 . 인데 물이 있으면 return false, 그게 아니면 return true.
			for (int i = 0; i < 4; i++) {
				int ty = y + my[i];
				int tx = x + mx[i];
				if (0 <= ty && ty < R && 0 <= tx && tx < C && map[ty][tx] == '*') {
					// 벗어나지 않는 데 물이 있으면 -> 못가는.
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
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
