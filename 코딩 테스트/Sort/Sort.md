[C++] Sort 함수

## 배열의 경우
~~~cpp
#include <iostream>
#include <algorithm>

using namespace std;

int main (){

    int a[100];

    // 초기화를 했다고 가정

    // 정렬
    // 첫번째 인자는 시작지점 = 배열의 포인터
    // 두번째 인자는 끝나는지점 + 1 = a(배열의 포인터) + 배열의 크기
    sort(a, a+100);
}
~~~

## 벡터의 경우
~~~cpp
#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main (){

    vector<int> a(100);

    // 초기화를 했다고 가정

    // 정렬
    // 첫번째 인자는 시작지점 = iterator의 begin()
    // 두번째 인자는 끝나는지점 + 1 = iterator의 end()
    sort(a.begin(), a.end());    
}
~~~


## sort() 사용하기(비교함수 이용하기)
    - 때로는 직접 비교함수를 추가해줘야하는 경우가 있다 사용법은 위와 동입하며 함수만 3번째 인자로 추가해주면 된다.
    - Point라는 구조체를 정렬한다고 가정해보자.
~~~cpp
#include <iostream>
#include <algorithm>

using namespace std;

struct Point{
    int x;
    int y;
};

// const와  &를 통해서 레퍼런스로 받아오는걸 잊지말자!
// x순으로 정렬하고 x값이 같으면 y순으로 각각 오른차순으로 정렬
bool cmp(const Point &p1, const Point &p2){
    if(p1.x < p2.x){
        return true;
    }
    else if(p1.x == p2.x){
        return p1.y < p2.y;
    }
    else{
        return false;
    }
}

int main (){

    Point a[100];

    // 초기화를 했다고 가정

    // 정렬
    // 첫번째 인자는 시작지점 = 배열의 포인터
    // 두번째 인자는 끝나는지점 + 1 = a(배열의 포인터) + 배열의 크기
    sort(a, a+100, cmp);
}
~~~

## stable_sort() 사용하기
- stable_sort()는 구조체처럼 여러 값들이 묶여 있을 때 하나의 요소로 정렬을 했을 때 다른 요소들의 정렬 순서도 정렬 전과 같이 그대로 유지 될 수 있도록 하는 정렬이다.
~~~cpp
#include <iostream>
#include <algorithm>

using namespace std;

struct Point{
    int x;
    int y;
};

// const와  &를 통해서 주소값을 받아오는걸 잊지말자!
// x순으로 정렬하고 x값이 같으면 y순으로 각각 오른차순으로 정렬
bool cmp(const Point &p1, const Point &p2){
    if(p1.x < p2.x){
        return true;
    }
    else if(p1.x == p2.x){
        return p1.y < p2.y;
    }
    else{
        return false;
    }
}

int main (){

    Point a[100];

    // 초기화를 했다고 가정

    // 정렬
    // 첫번째 인자는 시작지점 = 배열의 포인터
    // 두번째 인자는 끝나는지점 + 1 = a(배열의 포인터) + 배열의 크기
    stable_sort(a, a+100, cmp);
}
~~~

## 사용 예시 (완주하지 못한 선수)
~~~cpp
#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

string solution(vector<string> participant, vector<string> completion) {
    string answer = "";
    
    //사전순 정렬
    sort(participant.begin(), participant.end());
    sort(completion.begin(), completion.end());
    
    for(int i=0; i<participant.size();i++){
        if(participant[i]!=completion[i]){
            answer = participant[i];
            if(i==participant.size()-1)
                cout << completion[i] <<"dd";
            break;
        }        
        
    }
    
 
    return answer;
}
~~~