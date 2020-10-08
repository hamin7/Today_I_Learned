package While.P10951;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.io.BufferedWriter;
//import java.io.OutputStreamWriter;

public class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str;
		
		while( (str = br.readLine()) != null) {
			
			int num1 = Integer.valueOf(str.charAt(0) - '0');
			int num2 = str.charAt(2) - '0';

//			bw.write(num1);
			System.out.println(num1+num2);
		}

	}
}
