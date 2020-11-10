import java.util.Arrays;

public class Solution1 {
    public int solution(int[] winnum, int bonus, int[] usernum) {
        int answer = 0;
        int correct = 0;
        int isBonusCorrect = 0;

        Arrays.sort(usernum);

        for (int i = 0; i < winnum.length; i++) {
            for (int j = 0; j < usernum.length; j++) {
                if (bonus == usernum[i]) {
                    isBonusCorrect = 1;
                }
                if (winnum[i] == usernum[j]) {
                    correct++;
                    break;
                }
            }
        }

        if (correct == 6) {
            answer = 1;
        } else if (correct == 5 && isBonusCorrect == 1) {
            answer = 2;
        } else if (correct == 5 && isBonusCorrect == 0) {
            answer = 3;
        } else if (correct == 4) {
            answer = 4;
        } else if (correct == 3) {
            answer = 5;
        } else {
            answer = -1;
        }

        return answer;
    }
}
