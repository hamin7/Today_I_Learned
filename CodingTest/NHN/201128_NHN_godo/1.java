//핵심 소스코드의 설명을 주석으로 작성하면 평가에 큰 도움이 됩니다.
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public class Solution{
    public int solution(int[] goods){
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> cart = new ArrayList<Integer>();
        
        for (int i = 0; i < goods.length; i++) {
            list.add(goods[i]);
        }
        
        Collections.sort(list);
        
        int tmp = 0;
        for (int i = 0; i < list.size(); i++) {
            tmp += list.get(i);
            
            if (tmp >= 50) {
                cart.add(tmp);
                tmp = 0;
            }
        }
        
        int total = 0;
        for (int i = 0; i < cart.size(); i++) {
            total += (cart.get(i) - 10);
        }
        total += tmp;
        
        return total;
    }
}