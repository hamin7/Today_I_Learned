/*
파라미터를 어떻게 조작하느냐에 따라서 체크인 생략 가능
시작점을 만들 때, 주어진 시작점에서 for문으로 시작해도 되고, 가상의 점을 하나 만들어서 그곳에서 시작으로 만들어도 된다.
체크인 하는 방식이 조금 빠르다. 이 코드의 맹점은 dfs함수의 String pwd를 +연산 한다는 맹점이 있다. 
String + 무언가는 new를 한다. 새로운 string을 생성한다는 것인데 performance가 매우 떨어진다.
알아보긴 쉽지만 효율이 떨어진다는 말이다.
대안은 List<Character>를 쓰는 방법이 있다.
또 다른 방식은 stringBuilder라는 것이 있다.
list는 뒤를 빼는 것이 편하지만 stringBuilder는 뒤를 빼는 것이 약간 불편하다.
현업에서 전역변수 쓰는것은 지양할 것.
String + 연산이 말도 안되게 느리므로 stringBuilder가 비교적 빠르다.
*/

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
//	고슴도치가 간 곳을 dp에 저장할 것이다.
//	boolean형이 아니라 int형이라 몇번째로 지나갔는지를 의미.
	static int[][] dp;
	
	static Queue<Point> queue;
	static boolean foundAnswer;
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("/Users/hamin/eclipse-workspace/SamsungSDS/src/Day01/P3055/input.txt"));
		
		Scanner sc = new Scanner(System.in);
		
		R = sc.nextInt();
		C = sc.nextInt();
		
//		System.out.println(R + ", " + C);
		
		map = new char[R][C];
		dp = new int[R][C];
		queue = new LinkedList<>();
		
		List<Point> waterList = new ArrayList<>();
		for (int r = 0; r < R; r++) {
			String line = sc.next();
			for (int c = 0; c < C; c++) {
				map[r][c] = line.charAt(c);
//				시작점인가 봐야함.
				if (map[r][c] == 'S') {
//					시작점이면 queue에 넣어줘야.
					queue.add(new Point(r, c, 'S'));
				} else if (map[r][c] == '*') {
					waterList.add(new Point(r, c, '*'));
				}
			}
		}
//		waterList가 뭉텅이로 들어감.
		queue.addAll(waterList);
		
//		for (int r = 0; r < R; r++) {
//			System.out.println(Arrays.toString(map[r]));
//		}
		
//		System.out.println(queue);
		
		while(!queue.isEmpty()) {
//			1. 큐애서 꺼내옴.
			Point p = queue.poll();
//			2. 목적지인가?		if (p == 'D')
			if (p.type == 'D') {
				// 목적지 도착.
//				현재 자리까지 오는데 걸린 시간 출력.
				System.out.println(dp[p.y][p.x]);
				foundAnswer = true;
				break;
			}
//			3. 갈 수 있는 곳을 순회.		for (좌, 우, 위, 아래)
			for (int i = 0; i < 4; i++) {
				int ty = p.y + my[i];
				int tx = p.x + mx[i];
//				4. 		갈 수 있는가? 		if( 맵을 벗어나지 않고, x가 아니고, * 아니고(현재 물이 아니고 다음턴에도 물이 아닌))
//				지도에서 벗어나지 않는 것 체크.
				if ( 0 <= ty && ty < R && 0 <= tx && tx < C) {
//					벗어나지 않는 좌표인데 이게 .이냐 S냐에 *이냐에 따라 동작 달라짐.
					if (p.type == '.' || p.type == 'S') {
//						내가 간적이 없고, 안전한 자리면.
						if (dp[ty][tx] == 0 && checkSafe(ty, tx)) {
//							5. 			체크인.		dp[r][c] = time
//							내가 현재까지 오게 된 자리 + 1.
							dp[ty][tx] = dp[p.y][p.x]+ 1; 
//							6. 			큐에 넣음.		queue.add(next)+
							queue.add(new Point(ty, tx, map[ty][tx]));
						} 
					} else if (p.type == '*' && map[ty][tx] == '.') {
//						6. 			큐에 넣음.		queue.add(next)
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
	
//	x가 아니고, * 아니고, *에 인접한 .도 아니 체크.
	static boolean checkSafe(int y, int x) {
		if (map[y][x] == 'D') {
			return true;
		} else if (map[y][x] == '.') {
//			다음 점이 . 인데 물이있으면 return false, 그게 아니면 return true.
			for (int i = 0; i < 4; i++) {
				int ty = y + my[i];
				int tx = x + mx[i];
				if (0 <= ty && ty < R && 0 <= tx && tx < C && map[ty][tx] == '*') {
//					벗어나지 않는데 물이 있으면 -> 못가는.
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
