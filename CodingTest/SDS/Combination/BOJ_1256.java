import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class BOJ_1256 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        BigInteger K = new BigInteger(st.nextToken());
        BigInteger combi = combination(N, M);
        
        if(combi.compareTo(K) == -1){
            bw.write("-1" + "\n");
        } else {
            String ans = "";
            combi = BigInteger.ZERO;
            while(combi.compareTo(K) != 0){
                BigInteger combiTemp = combi;
                combi = combi.add(combination(N - 1, M));
                if(combi.compareTo(K) == -1){
                    M--;
                    ans += "z";
                } else {
                    N--;
                    ans += "a";
                    combi = combiTemp;
                }
                if(N == 0 || M == 0){
                    break;
                }
            }
            for(int i = 1; i <= M; i++){
                ans += "z";
            }
            for(int i = 1; i <= N; i++){
                ans += "a";
            }
            bw.write(ans + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    public static BigInteger combination(int N, int M){
        BigInteger combiup = new BigInteger("1");
        BigInteger combidown = new BigInteger("1");
        for(int i = 1; i <= N; i++){
            combiup = combiup.multiply(new BigInteger(String.valueOf((N+M)-(i-1))));
            combidown = combidown.multiply(new BigInteger(String.valueOf(i)));
        }
        return combiup.divide(combidown);
    }
}