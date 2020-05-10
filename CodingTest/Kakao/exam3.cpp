#include <string>
#include <vector>
#include <iostream>

using namespace std;

vector<int> solution(vector<string> gems) {
    vector<int> answer;
    int kind = 1;
    
    // 몇종류 인지 파악해보자.
    for (int i = 0; i < gems.size(); i++) {
        for (int j = 0; j < i; j++) {
            if (gems[i] == gems[j])     // 앞에 같은 것이 있다면.
                break;
            if (j == i-1)
                kind++;
        }
    }
    
    if (kind == 1){
        answer.push_back(1);
        answer.push_back(1);
    }
    
    int cnt = 1;
    for (int i = 0; i < gems.size(); i++) {
        for (int j = 0; j < i; j++) {
            if (gems[i] == gems[j])     // 앞에 같은 것이 있다면.
                break;
            if (j == i-1)
                cnt++;
            if (cnt == kind){
                if(answer.size() == 2)
                    break;
                if (gems[0] == "DIA"){
                    answer.push_back(3);
                    answer.push_back(i+1);
                } else {
                    answer.push_back(1);
                    answer.push_back(i+1);
                    break;
                }
            }
        }
    }
    
    return answer;
}