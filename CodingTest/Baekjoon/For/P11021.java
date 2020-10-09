// package For.P11021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class P11021 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int i = 1; i <= T; i++) {
			String input = br.readLine();
			String[] inputArray = input.split(" ");
			int a = Integer.parseInt(inputArray[0]);
			int b = Integer.parseInt(inputArray[1]);
			bw.write("Case #"+i+": "+ (a+b) + "\n");
		}
		
		bw.flush();
		br.close();
	}

}
