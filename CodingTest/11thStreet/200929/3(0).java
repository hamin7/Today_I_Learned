// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // collect frequency of each element 
        HashMap<Integer,
                  Integer> mpp = new HashMap<Integer,
                                          Integer>(); 
     
        for(int i:A)
        {
            if(mpp.containsKey(i))
                mpp.put(i, mpp.get(i) + 1); 
            else
                mpp.put(i, 1); 
        }
     
        // array of unique values taken 
        Vector<Integer> taken = 
                            new Vector<Integer>(); 
     
        int ans = 0; 
     
        for (int x = 0; x < 100000; x++) 
        { 
             
              // If number is present 
              // multiple times
              if (mpp.containsKey(x) && mpp.get(x) >= 2) 
            {
                taken.add(x * (mpp.get(x)- 1)); 
            }
           
              // If there is no x in the array
            else if(taken.size() > 0 && 
                    ((mpp.containsKey(x) && 
                    mpp.get(x) == 0)||!mpp.containsKey(x))) 
            { 
                ans += x - taken.get(taken.size() - 1); 
                taken.remove(taken.size() - 1); 
            } 
        } 
     
        // return answer 
        return ans; 
    }
}
