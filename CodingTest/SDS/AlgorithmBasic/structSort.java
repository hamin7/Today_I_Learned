package Day01.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class sortTest {

	public static void main(String[] args) {
		Point[] array = new Point[5];
		
		array[0] = new Point(0, 0, 1);
		array[1] = new Point(0, 1, 3);
		array[2] = new Point(0, 2, 4);
		array[3] = new Point(3, 0, 5);
		array[4] = new Point(4, 0, 2);
		
		System.out.println(Arrays.toString(array));
		
		// 포인터를 무엇을 기준으로 정렬할지 정보가 없다.
//		Arrays.sort(array);
		
		// Comparator는 인터페이스, 구현하지 않으면 사용 불가능
		// 특별한 조건의 정렬 속성으로 이용가능.
		Arrays.sort(array, new Comparator<Point>() {
			@Override
			// Point와 Point를 비교할 수 있는 얘
			public int compare(Point arg0, Point arg1) {
				if (arg0.y < arg1.y) { // -1 : 데이터를 바꾸지 않음 => 우리가 원하는 순서.
					return -1;
				} else if (arg0.y == arg1.y) { // 0 : 같음.
					if (arg0.value < arg1.value) {
						return -1;
					} else if (arg0.value == arg1.value) {
						return 0;
					} else {
						return 1;
					}
				} else { // 1 : 데이터를 바꿈 => 우리가 원하는 순서가 아님.
					return 1;
				}
			}
		});
		System.out.println(Arrays.toString(array));
		
		Arrays.sort(array);
		System.out.println(Arrays.toString(array));
		
		List<Point> list = new ArrayList<>();
		for (int i = 0; i < array.length; i++) {
			list.add(array[1]);
		}
		System.out.println(list);
		Collections.sort(list);
		Collections.sort(list, new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				// TODO Auto-generated method stub
				return 0;
			}
			
		});
	}
}

class Point implements Comparable<Point>{	// 기본 정렬의 속성으로 이용가능.
	int x;
	int y;
	int value;
	
	public Point(int x, int y, int value) {
		super();
		this.x = x;
		this.y = y;
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "[x = " + x + ", y = " + y + ", value = " + value + "]";
	}

	@Override
	public int compareTo(Point arg0) {	// 파라미터가 상대 것 밖에 없는 이유는 내꺼는 가지고 있으니까.
		if (x > arg0.x) {
			return -1;
		} else if (x == arg0.x) {
			return 0;
		} else {
			return 1;
		}
	}
}
