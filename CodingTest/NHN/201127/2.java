//핵심 소스코드의 설명을 주석으로 작성하면 평가에 큰 도움이 됩니다.
public class Solution{
    public int knapsack(int[] w, int[] v, int k){
        int n = w.length;       // number of jewelry
        JewE jew[] = new JewE[n+1];
        
        for (int i = 1; i <= n; i++) {
            jew[i] = new JewE(w[i-1], v[i-1]);
        }
        int table[][] = new int[n+1][k+1];      // table that saves profit
        
        for (int i = 1; i <= n; i++) {
            // row : item
            for (int j = 1; j < table[i].length; j++) {
                // column : weight of bag
                if (jew[i].weight > j) {
                    table[i][j] = table[i-1][j];
                } else {
                    table[i][j] = Max(jew[i].profit+table[i-1][j-jew[i].weight], table[i-1][j]);
                }
            }
        }
        
        return table[n][k];
    }
    
    int Max(int a, int b) {
        return a > b ? a : b;
    }
    
    class JewE {
        int weight;
        int profit;
        JewE(int weight, int profit) {
            this.weight = weight;
            this.profit = profit;
        }
    }
}