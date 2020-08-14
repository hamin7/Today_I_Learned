import javax.management.Query;

public class BOJ_1256_1 {
    K = Integer.parseInt(st.nextToken());

    if ( K > combination(N + M >, M)) {
        System.out.println("-1");
    } else {
        query(N, M, K);
        System.out.println(sb.toString());
    }
}

// n : a 의 개수, m : z의 개수, k 번째.
static void query(int n, int m, int k) {
    // n + m== 0 끝
    if(n + m == 0){
        return;
    }
    // n == 0 선택할 a가 더 없음 -> z로 채움
    else if(n == 0) {
        sb.append("z");
        query(n, m - 1, k);
    }
    // n == 0 선택할 z가 없음 -> a로 채움
    else if(m == 0) {
        sb.append("a");
        query(n - 1, m, k);
    }
    // a나 z를 선택해야 하는 케이스
    else {
        int aCount = combination(n + m - 1, m);
        if(aCount >= k) {
            sb.append('a');
            query(n, m - 1, k - aCount);
        }
    }
}

static int combination(int n, int r) {
    if (n == r || r == 0){
        return 1;
    } else if (dp[n][r] != 0) {
        return dp[n][r];
    } else {
        return dp
    }
}