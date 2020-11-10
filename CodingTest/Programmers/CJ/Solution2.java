import java.util.ArrayList;
import java.util.Arrays;

public class Solution2 {
    static ArrayList<Integer> list = new ArrayList<>();
    static ArrayList<ArrayList> list2 = new ArrayList<>();
    static int electionCount = 0;       // 투표 횟수
    static int king = 0;        // 당선된 학생의 출석번호

    public int[] solution(int[][] orders) {
        int[] answer = new int[2];
        int numberOfStudents = orders.length;
        boolean flag = false;

        for (int i = 0; i < orders.length; i++) {
            list = new ArrayList<>();
            for (int j = 0; j < orders[0].length; j++) {
                list.add(orders[i][j]);
            }
            list2.add(list);
        }

        // flsg = election(numberOfStudents);

        while (flag == false) {
            flag = election(numberOfStudents);
        }


        // 투표 횟수, 당선된 학생의 출석번호
        answer[0] = electionCount;
        answer[1] = king;
        return answer;
    }

    public static boolean election(int numberOfStudents) {
        int half = 0;       // 반수
        if (numOfStudents % 2 == 0) {
            half = numOfStudents / 2;
        } else {
            half = numOfStudents / 2 + 1;
        }

        // 1. 체크인
        // 투표횟수 + 1
        electionCount++;

        // 투표 받은 횟수
        int[] getSupport = new int[list2.size()];

        // i번째 사람이 j번에 투표했는지 판별
        for (int i = 0; i < list2.size(); i++) {
            int who = Integer.parseInt(list2.get(i).get(0).toString());
            getSupport[who]++;
        }

        // 최다표 찾기
        // 배열 복사
        int[] tempGetSupport = new int[getSupport.length];
        for (int i = 0; i < getSupport.length; i++) {
            tempGetSupport[i] = getSupport[i];
        }
        Arrays.sort(tempGetSupport);
        int max = 0;        // 최다표
        max = tempGetSupport[getSupport.length - 1];

        // 반수 이상 득표하면 당선
        if (max >= half) {
            for (int i = list2.size() - 1; i >= 0; i++) {
                if (max == getSupport[i]) {
                    king = i;
                    return true;
                }
            }
        }

        int min = 0;        // 최소표
        int minStudent = 0;
        // 최소표 누군지 찾기
        for (int i = 0; i < list2.size(); i++) {
            if (min == getSupport[i]) {
                minStudent = i;
            }
        }

        // 최소값인 놈 제거
        for (int i = 0; i < list2.size(); i++) {
            for (int j = 0; j < list2.get(0).size(); j++) {
                if (minStudent == Integer.parseInt(list2.get(i).get(j).toString())) {
                    list2.get(i).remove(j);
                }
            }
        }

        return false;
    }
}
