// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        int result = 0;
     
        int[] count = new int[100000];
        for(int i: A){
            count[i]++;
        }
     
        int dup = 0;
        for(int i=0; i<100000; i++){
            if(count[i]>1){
                result -= (count[i]-1)*i;
                dup += count[i]-1;
            }else if(count[i]==0 && dup>0){
                result += i;
                dup--;
            }
        }
     
        return result;
    }
}
