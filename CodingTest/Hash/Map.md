# C++ STL Map 사용법과 예제

## 맵 기본 함수

### 기본형태
<ul>
    <li><code class="language-plaintext highlighter-rouge">map&lt;key,value&gt;</code> : key와 value를 pair 형태로 선언합니다.</li>
</ul>

### iterator(반복자)
<ul>
  <li><code class="language-plaintext highlighter-rouge">begin()</code> : beginning iterator를 반환</li>
  <li><code class="language-plaintext highlighter-rouge">end()</code> : end iterator를 반환</li>
</ul>

### 추가 및 삭제
<ul>
  <li><code class="language-plaintext highlighter-rouge">insert( make_pair(key,value) )</code> : 맵에 원소를 <code class="language-plaintext highlighter-rouge">pair</code> 형태로 추가</li>
  <li><code class="language-plaintext highlighter-rouge">erase(key)</code> : 맵에서 key(키값)에 해당하는 원소 삭제</li>
  <li><code class="language-plaintext highlighter-rouge">clear()</code> : 맵의 원소들 모두 삭제</li>
</ul>

### 조회
<ul>
  <li><code class="language-plaintext highlighter-rouge">find(key)</code> : key(키값)에 해당하는 iterator를 반환</li>
  <li><code class="language-plaintext highlighter-rouge">count(key)</code> : key(키값)에 해당하는 원소들(value들)의 개수를 반환</li>
</ul>

### 기타
<ul>
  <li><code class="language-plaintext highlighter-rouge">empty()</code> : 맵이 비어있으면 true 아니면 false를 반환</li>
  <li><code class="language-plaintext highlighter-rouge">size()</code> : 맵 원소들의 수를 반환</li>
</ul>



### 사용 예시 (완주하지 못한 선수)
~~~cpp
#include <string>
#include <vector>
#include <map>

using namespace std;

string solution(vector<string> participant, vector<string> completion) {

    int size = completion.size();

    map<string, int> name;
    int* num = new int[size];
    for(int i=0 ; i<size ; i++)
    {
        num[i] = 1;
    }

    //completion으로 명단 작성
    map<string, int>::iterator it;
    for(int i=0 ; i<size ; i++)
    {
        it = name.find(completion[i]);
        if(name.count(completion[i]) == 0)
            name.insert(pair<string, int>(completion[i], i));
        else //이미 있으면 인원 추가
            num[it->second]++;
    }

    //participant로 명단과 대조하여 체크
    for(int i=0 ; i<size+1 ; i++)
    {        
        if(name.count(participant[i]) == 0) //명단에 없으면 바로 출력
            return participant[i];
        else //명단에 있으면
        {
            it = name.find(participant[i]);

            if(num[it->second] <= 0)
                 return participant[i];
            else
                 num[it->second]--;
        }
    }

    return "";
}
~~~

참고 블로그 : https://twpower.github.io/91-how-to-use-map-in-cpp <br>
https://blockdmask.tistory.com/87