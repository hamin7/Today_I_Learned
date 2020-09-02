#include <string>
#include <vector>
#include <iostream>

using namespace std;

vector<int> solution(int brown, int yellow) {
    vector<int> answer;
    int total, horizon, vertical;
    
    total = brown+yellow;
    
    for (horizon = 3; horizon < brown/2; horizon++) {
        // total이 horizon으로 나눠떨어지면
        if (total % horizon == 0) {
            vertical = total / horizon;
            if (horizon >= vertical && (horizon-2)*(vertical-2) == yellow){
                answer.push_back(horizon);
                answer.push_back(vertical);
                break;
            }
        }
    }
    
    return answer;
}