// you can use includes, for example:
#include <algorithm>
#include <vector>

// you can write to stdout for debugging purposes, e.g.
// cout << "this is a debug message" << endl;

int solution(vector<int> &A) {

    // write your code in C++14 (g++ 6.2.0)
    sort(A.begin(), A.end());
    unique(A.begin(), A.end());
    
    int index = 1;
    for(int i=0;i<(int)A.size();i++){
        if(A[i]<=0){
            continue;
        }
            
        if(A[i]!=index)
            return index;
            
        index++;
    }
    if(index==1) return 1;
    else return index;
}
