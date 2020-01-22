# 우선순위 큐 기본 함수
## 기본형태
<ul>
    <li>priority_queue<T, Container, Compare> : 원하는 자료형 및 클래스 T를 통해 생성. 여기서 Container는 vector와 같은 컨테이너이며 Compare는 비교함수 클래스이다.
</ul>

## 추가 및 삭제
<ul>
    <li>push(element) : 우선순위 큐에 원소 추가
    <li>pop() : 우선순위 큐에서 top의 원소를 삭제
</ul>

## 조회
<ul>
    <li>top() : top에 있는 원소를 반환
</ul>

## 기타
<ul>
    <li>empty() : 비어있으면 true 아니면 false를 반환
    <li>size() : 우선순위 큐에 포함되어 있는 원소들의 수를 반환
</ul>

## 사용 예시 (프린터)
~~~cpp
#include <string>
#include <vector>
#include <queue>
using namespace std;

int solution(vector<int> priorities, int location) {
    int answer = 0;
    
    queue<pair<int,int>> seq;   //<중요도,priorities의 인덱스> 쌍
    priority_queue<int> important;  //중요도 순 저장
    
    for(int i=0;i<priorities.size();i++){
        seq.push(make_pair(priorities[i],i));
        important.push(priorities[i]);
    }
    
    while(!seq.empty()){
        if(important.top()==seq.front().first){ //출력
            answer++;
            if(seq.front().second == location)  break;
            seq.pop();
            important.pop();      
        }
        else{
            seq.push(make_pair(seq.front().first, seq.front().second));
            seq.pop();
        }
    }
    
    return answer;
}
~~~

## 구현 코드(Max Heap)
~~~cpp
#include <iostream>
#include <functional>
#include <queue>

using namespace std;

int main(){

	// priority_queue
	priority_queue< int, vector<int>, less<int> > pq;
	// or priority_queue<int> pq;


	// push(element)
	pq.push(5);
	pq.push(2);
	pq.push(8);
	pq.push(9);
	pq.push(1);
	pq.push(14);


	// pop()
	pq.pop();
	pq.pop();


	// top();
	cout << "pq top : " << pq.top() << '\n';


	// empty(), size()
	if(!pq.empty()) cout << "pq size : " << pq.size() << '\n';


	// pop all
	while(!pq.empty()){
		cout << pq.top() << " ";
		pq.pop();
	}

	cout << '\n';

	return 0;

}
~~~