class sample {
    public int[] solution(int[][] v) {
        int[] answer = {0, 0};
        
        // count x pair
        int[] pairX = new int[2];
        pairX[0] = v[0][0];
        int count1 = 1;
        int count2 = 0;
        
        for (int i = 1; i < v.length; i++) {
            if (v[i][0] == pairX[0]) {
                count1++;
            } else if (pairX[1] == 0) {
                pairX[1] = v[i][0];
                count2++;
            } else {
                count2++;
            }
        }
        
        if (count1 == 1) {
            answer[0] = pairX[0];
        } else {
            answer[0] = pairX[1];
        }
        
        // count y pair
        int[] pairY = new int[2];
        pairY[0] = v[0][1];
        count1 = 1;
        count2 = 0;
        
        for (int i = 1; i < v.length; i++) {
            if (v[i][1] == pairY[0]) {
                count1++;
            } else if (pairY[1] == 0) {
                pairY[1] = v[i][1];
                count2++;
            } else {
                count2++;
            }
        }
        
        if (count1 == 1) {
            answer[1] = pairY[0];
        } else {
            answer[1] = pairY[1];
        }

        System.out.println(answer[0] + "," + answer[1]);
        
        return answer;
    }
}