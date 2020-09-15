import java.util.*;

class Solution {
    public int[] solution(int[] ball, int[] order) {
        int[] answer = {};
        ArrayList<Integer> priority = new ArrayList<Integer>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> ballList = new ArrayList<Integer>();
        
        for (int i = 0; i < ball.length; i++) {
            ballList.add(ball[i]);
        }
        
        for (int i = 0; i < order.length; i++) {
//          priority에 있는것 먼저 체크.
            if (priority.size() != 0){
                for (int j = 0; j < priority.size(); j++) {
                    if (priority.get(j) == ballList.get(0)) {
                        // priority의 이번 것이 ball의 맨 앞 것이라면
                        // list에 추가해주기
                        list.add(priority.get(j));
                        // priority에서 이번 것 제거.
                        priority.remove(j);
                        // ball 하나씩 앞으로 당기기.
                        ballList.remove(0);
                    } else if (priority.get(j) == ballList.get(ballList.size() - 1)) {
                        // priority의 이번 것이 ball의 맨 뒤 것이라면
                        // list에 추가해주기
                        list.add(priority.get(j));
                        // priority에서 이번 것 제거.
                        priority.remove(j);
                        // ballList 마지막것 제거
                        ballList.remove(ballList.size()-1);
                    }
                }
            }
            
            if (order[i] == ballList.get(0)) {
                // order 이번 순위 것이 ball의 젤 앞에 있다면.
                ballList.remove(0);      // 이번꺼 삭제
                
                // 이번 공을 list로
                list.add(order[i]);
                
            } else if (order[i] == ballList.get(ballList.size() - 1)) {
                // order 이번 순위 것이 ball의 맨 뒤에 있다면.
                // ball[마지막]을 빼고 다시 ball[] 만들 것
                ballList.remove(ballList.size()-1);      // 이번꺼 삭제
                
                // 이번 공을 list로
                list.add(order[i]);
            } else {
                // 둘 다 아니라면 중간에 끼어 있는 것이니 priority에 넣자.
                priority.add(order[i]);
            }
        }
        
        answer = new int[list.size()];
        
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}