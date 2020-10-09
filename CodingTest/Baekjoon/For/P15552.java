// package For.P15552;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P15552 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine().trim());
		
		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			String[] inputArray = input.split(" ");
			int a = Integer.parseInt(inputArray[0]);
			int b = Integer.parseInt(inputArray[1]);
			bw.write(a+b + "\n");
		}
		
		bw.flush();
		br.close();
	}

}
