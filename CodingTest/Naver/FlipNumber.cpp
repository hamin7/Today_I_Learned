// you can use includes, for example:
#include <algorithm>
#include <vector>

// you can write to stdout for debugging purposes, e.g.
// cout << "this is a debug message" << endl;

int getFlipNumber(vector<int> &coins, int flag){
    
    int count = 0;
    
    for(int i=0; i<coins.size();i++){
        if(coins[i]!=flag)
            count++;
        
        flag = (flag ==0) ? 1: 0;
    }
    return count;
    
}
int solution(vector<int> &A) {
    // write your code in C++14 (g++ 6.2.0)
    
    
    return min(getFlipNumber(A, 0), getFlipNumber(A,1));
}


// 참고 : https://www.geeksforgeeks.org/number-flips-make-binary-string-alternate/
