package Queue_Stack.P1662;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	
	static int[] parentheses = new int[50];		// 열린 괄호의 자리에 닫히는 짝 괄호의 위치를 저장
	static char[] compressed;		// 압축 된 문자열을 저장

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> st = new Stack<Integer>();
		
		compressed =  br.readLine().toCharArray();
		
		for (int i = 0; i < compressed.length; i++) {
			if (compressed[i] == '(') {
				st.push(i);
			} else if (compressed[i] == ')') {
				parentheses[st.pop()] = i;
			}
		}
		System.out.println(traversal(0, compressed.length));
	}

	// 재귀를 쓰자
	static int traversal (int start, int end) {
		int stringLength = 0;
		
		for (int i = start; i < end; i++) {
			if (compressed[i] == '(') {
				// 앞에 숫자로 곱하는데 이미 앞에 숫자를 stringLength에 더했으므로 1 빼주기
				stringLength += (compressed[i - 1] - '0') * traversal(i+1, parentheses[i]) - 1;
				i = parentheses[i];
			} else {
				stringLength++;
			}
		}
		return stringLength;
	}
}
