#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> answers) {
    vector<int> answer;
    
    vector<int> one = {1,2,3,4,5};
    vector<int> two = {2,1,2,3,2,4,2,5};
    vector<int> three = {3,3,1,1,2,2,4,4,5,5};
    
    vector<int> score(3);
    
    // 각각 몇 개씩 맞췄는지 채점
    for (int i = 0; i < answers.size(); i++){
        if (answers[i] == one[i%5])
            score[0]++;
        if (answers[i] == two[i%8])
            score[1]++;
        if (answers[i] == three[i%10])
            score[2]++;
    }
    
    // 최고점수 구하기
    int max_score = *max_element(score.begin(), score.end());
    
    // 최고점수를 얻은 수포자 answer에 넣기
    for (int i = 0; i < 3; i++) {
        if (score[i] == max_score) {
            answer.push_back(i+1);
        }
    }
    
    return answer;
}