package While.P1110;

import java.io.BufferedReader;
//import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int firstNum = Integer.parseInt(br.readLine());
		int count = 0;
		int newNum = firstNum; 
		
		while (true) {
			newNum = ( (newNum % 10)*10 + ((newNum/10) + (newNum%10))%10);
			count++;
			
			if (newNum == firstNum)
				break;
		}
		
		System.out.println(count);
//		bw.write(count + "\n");
//		bw.flush();
//		bw.close();
	}
}
