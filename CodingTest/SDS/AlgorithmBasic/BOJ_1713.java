package Day01.P1173;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int n, k;
	static int[] inputs;
	static Person[] people = new Person[101];	// 1번부터 써야하기 때문에.

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("/Users/hamin/eclipse-workspace/SamsungSDS/src/Day01/P1173/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		
		inputs = new int[k];
		
		// List가 넣었다 뻈다 하기 편하기 때문에 List로 하자.
		List<Person> list = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		for (int i = 0; i < k; i++) {
			int num = Integer.parseInt(st.nextToken());		// num은 people의 번호.
			
			// 초기화.
			if (people[num] == null) {
				people[num] = new Person(num, 0, 0, false);
			}
			
			// 사진틀에 있는 경우. -> 해당 후보의 count++
			if (people[num].isIn == true) {
				people[num].count++;
			} else { // 사진틀에 없는 경우.
				// 사진틀이 꽉찬 경우.
				if (list.size() == n) {
					// list 정렬 -> 제일 count 적은사람이 앞으로.
					Collections.sort(list);		// 한명 제거하기 위해 sort 사용.
					Person p = list.remove(0);		// 첫 번째 사람이 제일 적은 count를 가지므로 제거. 
					// remove는 리스트에서 제거하고 그 객체를 리턴함. 
					p.isIn = false;
				}
				// 사진틀이 꽉 차지 않은 경우.
				// 후보 추가.
				people[num].count = 1;
				people[num].isIn = true;
				people[num].timeStamp = i;		// i번째 호출된 후보.
				list.add(people[num]);
			}
			
			// 기본 정렬기능 쓰지말고 num순으로 정렬하자.
			Collections.sort(list, new Comparator<Person>() {
				// -1 : 원하는 기준, 0 : 같음, 1 : 원하는 순서가 아님.
				@Override
				public int compare(Person arg0, Person arg1) {
					if (arg0.num < arg1.num) {
						return -1;
					} else if (arg0.num == arg1.num){
						return 0;
					} else {
						return 1;
					}
				}
			});
//			System.out.println(list);
		}
		// 인덱스 신경 안 쓰고 전체 돌리기.
		for (Person person : list) {
			System.out.print(person.num+" ");
		}
	}
}

class Person implements Comparable<Person>{
	int num;
	int count;
	int timeStamp;
	boolean isIn;
	
	// 번호, 추천 받은 수, 추천 받은 시간, 사진틀에 있는지 여부.
	public Person(int num, int count, int timeStamp, boolean isIn) {
		super();
		this.num = num;
		this.count = count;
		this.timeStamp = timeStamp;
		this.isIn = isIn;
	}
	
	@Override
	public String toString() {
		return "[num = " + num + ", count = " + count + ", timeStamp = " + timeStamp + ", isIn = " + isIn + "]";
	}
	
	@Override
	// -1 : 원하는 기준, 0 : 같음, 1 : 원하는 순서가 아님.
	public int compareTo(Person arg0) {
		// 작은 얘를 왼쪽으로 보내자.
		if (count < arg0.count) {
			return -1;
		} else if (count == arg0.count) {
			// timeStamp 비교.
			if (timeStamp < arg0.timeStamp) {
				return -1;
			} else if (timeStamp == arg0.timeStamp) {
				return 0;
			} else {
				return 1;
			}
		} else {
			return 1;
		}
	}
}