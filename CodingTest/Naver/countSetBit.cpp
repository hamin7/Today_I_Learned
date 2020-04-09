/ you can use includes, for example:
// #include <algorithm>

// you can write to stdout for debugging purposes, e.g.
// cout << "this is a debug message" << endl;

int solution(int A, int B) {
    // write your code in C++14 (g++ 6.2.0)
    
    int count = 0;
    int temp = A*B;
    while(temp){
        count  += temp & 1;
        temp >>= 1;
        
    }
    return count;
}
