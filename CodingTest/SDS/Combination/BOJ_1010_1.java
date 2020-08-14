import java.util.Scanner;

public class BOJ_1010_1 {
    static int T, N, M;

    static int[][] dp = new int[31][31];
    static int count;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src\\DAY05\\P1010\\input.txt"));
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            N = sc.next();
            M = sc.next();

            System.out.println(N + ", " + M);
            System.out.println(Combi(M, N));
        }
    }

    // n C k = n - 1 C k - 1 
}