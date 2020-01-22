## 큐 기본 함수
### 추가 및 삭제
<ul>
    <li> push(element) : 큐에 원소를 추가(뒤에)
    <li> pop() : 큐에 있는 원소를 삭제(앞에)
</ul>

### 조회
<ul>
    <li>front() : 큐 제일 앞에 있는 원소를 반환
    <li>back() : 큐 제일 뒤에 있는 원소를 반환
</ul>

### 기타
<ul>
    <li>empty() : 큐가 비어있으면 true 아니면 false를 반환
    <li>size() : 큐 사이즈를 반환
</ul>

## 사용 예시 (기능 개발)
~~~cpp
#include <vector>
#include <string>
#include <queue>

using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds){
    vector<int> answer;
    queue<pair<int, int>> q;

    // 큐에 작업의 갯수와 각각 걸리는 시간 푸시.
    for (int i = 0; i < progresses.size(); i++){
        q.push(make_pair(progresses[i], speeds[i]));
    }

    int day = 0;
    while (q.size() > 0){
        day++;

        int release = 0;    // 릴리즈 될 기능 갯수
        // 작업 진도 + 남은거 * day >= 100 이면 다 한거
        while(q.front().first + q.front().second*day >= 100){
            release++;
            q.pop();
        }if (release != 0 )
            answer.push_back(release);  // 릴리즈 가능한 기능 갯수 answer에 푸시.
    }
    return answer;
}

~~~

## 사용 예시2 (프린터)
~~~cpp
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> priorities, int location) 
{
    vector<int> temp = priorities;
    sort(temp.begin(), temp.end(), greater<int>());
    int answer = 0;
    int start = 0;
    int end = priorities.size() - 1;
    bool is_printed = false;

    int i = 0;

    while (!is_printed)
    {
        if (temp[answer] == priorities[start])
        {
            answer += 1;

            if (start == location)
                is_printed = true;
        }
        else
        {
            end = start;
        }

        start = (start + 1) % priorities.size();
    }

    return answer;
}
~~~