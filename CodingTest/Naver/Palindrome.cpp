// you can use includes, for example:
// #include <algorithm>
#include <string>
// you can write to stdout for debugging purposes, e.g.
// cout << "this is a debug message" << endl;

string solution(string &S) {
    // write your code in C++14 (g++ 6.2.0)
    int size = S.length();
    
    for(int i=0;i<size/2;i++){
        if(S[i] == S[size-i-1] || S[i] == '?' || S[size-i-1]=='?') {
            // cout << S[i] <<" "  << S[size-i-1] << endl;
            if(S[i]=='?' && S[size-i-1]=='?')
                S[i] = S[size-i-1] = 'a';
            else if(S[i]=='?')
                S[i] = S[size-i-1];
            else if (S[size-i-1]=='?')
                S[size-i-1] = S[i];

            
        }
        else if(S[i] != S[size-i-1] && S[i]!='?'  && S[size-i-1]!='?'){
            return "NO";   
        }
            

        
    }
    return S;
}
