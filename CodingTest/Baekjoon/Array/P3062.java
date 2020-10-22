package Array.P3062;

import java.util.Scanner;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] inputArray = new int[10];
		int[] remainderArray = new int[10];
		int numberVariety = 0;
		
		for (int i = 0; i < 10; i++) {
			inputArray[i] = sc.nextInt();
		}
		sc.close();
		
		remainderArray = makeRemainderArray(inputArray);
		
//		numberVariety = countNumberVariety(remainderArray);		// 둘 중 하나 사용하면 됨.
		numberVariety = countNumberVarietyBySet(remainderArray);		// 둘 중 하나 사용하면 됨.
		
		System.out.println(numberVariety);
	}
	
	public static int[] makeRemainderArray(int[] numbers) {
		int[] resultArray = new int[numbers.length];
		
		for (int i = 0; i < 10; i++) {
			resultArray[i] = numbers[i] % 42;
		}
		
		return resultArray;
	}
	
	// solution1 배열의 요소를 직접 확인하며 중복을 제거.
	public static int countNumberVariety(int[] array) {
		int result = 0;
		ArrayList<Integer> arrayList = new ArrayList<>();
		
		for (int data :array) {
			if (!arrayList.contains(data))
				arrayList.add(data);
		}
		
		result = arrayList.size();
		
		return result;
	}
	
	// solution2 Set을 이용하여 중복제거 (HashSet, LinkedHashSet, TreeSet)
	public static int countNumberVarietyBySet(int[] array) {
		int result = 0;
		
		HashSet<Integer> hashSet = new HashSet<>();
		LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
		TreeSet<Integer> treeSet = new TreeSet<>();
		for (int data : array) {
			hashSet.add(data);
			linkedHashSet.add(data);
			treeSet.add(data);
		}
		
		result = hashSet.size();
		
		return result;
	}
}
