# 벡터 기본 함수
## iterator(반복자)
<ul>
    <li>begin() : beginning iterator를 반환
    <li>end() : end iterator를 반환
</ul>

## 추가 및 삭제
<ul>
    <li>push_back(element) : 벡터 제일 뒤에 원소 추가
    <li>pop_back() : 벡터 제일 뒤에 원소 삭제
</ul>

## 조회
<ul>
    <li>[i] : i번째 원소를 반환
    <li>at(i) : i번째 원소를 반환
    <li>front() : 첫번째 원소를 반환
    <li>back() : 마지막 원소를 반환
</ul>

## 기타
<ul>
    <li>empty() : 벡터가 비어있으면 true 아니면 false를 반환
    <li>size() : 벡터 원소들의 수를 반환
</ul>

## 배열과의 차이
<li> 동적으로 원소를 추가할 수 있으며 크기가 자동으로 늘어난다.

## 사용 예시 (모의고사)
~~~cpp
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> one = {1,2,3,4,5};
vector<int> two = {2,1,2,3,2,4,2,5};
vector<int> thr = {3,3,1,1,2,2,4,4,5,5};

vector<int> solution(vector<int> answers) {

    vector<int> answer;
    vector<int> score(3);    // 기본값(0)으로 초기화 된 3개의 원소를 가지는 vector score 생성.

    // 각각 몇개씩 맞췄는지 비교.
    for(int i=0; i<answers.size(); i++){
        if(answers[i] == one[i%one.size()])
            score[0]++;
        if(answers[i] == two[i%two.size()])
            score[1]++;
        if(answers[i] == thr[i%thr.size()])
            score[2]++;
    }

    // max_score에 score 벡터 안에 있는 최댓값 삽입.
    int max_score = *max_element(score.begin(), score.end());

    // 최고점수와 같은 수포자 answer에 넣기.
    for(int i=0; i<3; i++){
        if(score[i] == max_score)
            answer.push_back(i+1);
    }

    return answer;
}
~~~

### 참고 : https://twpower.github.io/77-how-to-use-vector-in-cpp