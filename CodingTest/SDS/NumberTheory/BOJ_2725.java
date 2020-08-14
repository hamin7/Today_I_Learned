import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

// 에라토스테네스의 체.

public class BOJ_2725 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src\\DAY04\\P2725\\input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        C = Integer.parseInt(br.readLine());        // 뭐가 문제냐
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < C; i++){
            int N = Integer.parseInt(br.readLine());
            int result = 0;
            for (int j = 2; j <= N; j++) {
                result += euler(j);
            }
            result *= 2;
            result += 3;
            sb.append(result);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    
    // 
    static int euler(int n) {
        int result = 1;
        // Nㅇㅣ p ( 2 - N )로 나눠지는지 확인.
        for (int p = 2; p * p <= n; p++) {
            if (n % p == 0) {
                int pm = 1;
                while (n % p == 0) {
                    n /= p;
                    pm += p;
                }
                result *= (pm - (pm /p));
            }
            if (n != 1){
                result *= n-1;
            }
        }
        return result;
    }
}