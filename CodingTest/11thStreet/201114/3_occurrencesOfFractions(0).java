import java.util.*;

class Solution {
    static int countFrequentFraction(float[] num) {
        int most = 0;
        Set<Float> set1 = new HashSet<Float>();

        for (int i = 0; i < num.length; i++){
            set1.add(num[i]);
        }

        float[] set2 = new float[set1.size()];
        int b = 0;
        
        for(Float x : set1) set2[b++] = x;

        ArrayList<Float> d = new ArrayList<Float>();
        for (int i = 0; i < set2.length; i++){
            float c = 0;
            for (int j = 0; j < num.length; j++){
                if (set2[i] == num[j]){
                    c = c + 1;
                }
            }
            d.add(i, c);
        }

        float e = Collections.max(d);

        most = (int) e;

        return most;
    }

    // Function to count the frequnet fraction in the given array
    static int makeFraction(int num[], int den[], int N) {
        int answer = 0;
        float[] array = new float[N];

        for (int i = 0; i < N; i++) {
            array[i] = (float)((float)num[i] / (float)den[i]);
        }

        answer = countFrequentFraction(array);

        return answer;
    }

    public int solution(int[] X, int[] Y) {
        // write your code in Java SE 11
        int N = X.length;
        int answer = 0;

        answer = makeFraction(X, Y, N);
        
        return answer;
    }
}
