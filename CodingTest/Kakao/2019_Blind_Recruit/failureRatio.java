import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        // 각 stage에 있는 사람의 수 저장 -> 길이 N+2(0은 제외하자)의 ArrayList
        ArrayList<Integer> stageCount = new ArrayList<Integer>();
        
        // stageCount의 길이를 N+2의 길이만큼, 0으로 채워넣기.
        for (int i = 0; i < N+2; i++) {
            stageCount.add(0);
        }
        
        // stageCount의 각 단계에 있는 사람 수 넣기.
        for (int i = 0; i < stages.length; i++) {
            stageCount.set(stages[i], stageCount.get(stages[i])+1);
        }
        
        // 실패율 계산 -> stageCount.get(i) / (전체 인원 - 앞 단계 누적 인원)
        int sum = stages.length;
        int cumsum = 0;
        // (단계 : 실패율) 저장 할 pair 필요. 구조체로 해도 될 듯?
        List<Pair> list = new ArrayList<>();
        // stage 1 부터 존재.
        for (int i = 1; i < stageCount.size(); i++) {
            int userCount = stageCount.get(i);      // i번째 단계에 있는 사용자의 수.
            
            if (userCount == 0) {
                // i번째 단계에 있는 사람이 0명이면 -> 실패율 == 0
                Pair p1 = new Pair(i, 0);
                list.add(p1);
            } else {
                // i번째 단계에 있는 사람이 0명이 아니라면, 실패율 == stageCount.get(i) / (sum - cumsum)
                Pair p2 = new Pair(i, (double) stageCount.get(i) / (sum - cumsum));
                list.add(p2);
            }
            cumsum += userCount;    // 이번 단계 까지의 누적 사용자 수.
        }
        
        list.remove(list.size() - 1);       // 마지막 것은 모두 통과한 사람이므로 스테이지가 아님.
        
        // 실패율 높은 것 - 낮은 것 순으로 정렬
        Collections.sort(list);
        
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).stage;
        }
        
        return answer;
    }
}

class Pair implements Comparable<Pair> {
    int stage;
    double failureRatio;
    
    public Pair(int stage, double failureRatio) {
        this.stage = stage;
        this.failureRatio = failureRatio;
    }
    
    @Override
    public String toString() {
        return "stage : " + stage + ", failureRatio : " + failureRatio;
    }
    
    @Override
    // -1 : 원하는 기준, 0 : 같음, 1 : 원하는 순서가 아님
    public int compareTo(Pair arg0) {
        // 높은 것 에서 낮은 것 순.
        // 큰 것을 왼쪽으로 보내자.
        if (failureRatio > arg0.failureRatio) {
            return -1;
        } else if (failureRatio == arg0.failureRatio) {
            // stage 번호 비교, stage 번호가 작으면 왼쪽
            if (stage < arg0.stage) {
                return -1;
            } else if (stage == arg0.stage) {
                // 근데 이럴일은 없을 듯
                return 0;
            } else {
                return 1;
            }
        } else {
            return 1;
        }
    }
}
