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



### 구현코드
~~~cpp
#include <iostream>
#include <map>
#include <string>

using namespace std;

int main(){

	// map
	// <string, int> => <key, value>
	map< string, int > m;


	// insert(key,value)
	m.insert(make_pair("a", 1));
	m.insert(make_pair("b", 2));
	m.insert(make_pair("c", 3));
	m.insert(make_pair("d", 4));
	m.insert(make_pair("e", 5));
	m["f"] = 6; // also possible


	// erase(key)
	m.erase("d");
	m.erase("e");
	m.erase(m.find("f")); // also possible


	// empty(), size()
	if(!m.empty()) cout << "m size : " << m.size() << '\n';


	// find(key)
	cout << "a : " << m.find("a")->second << '\n';
	cout << "b : " << m.find("b")->second << '\n';


	// count(key)
	cout << "a count : " << m.count("a") << '\n';
	cout << "b count : " << m.count("b") << '\n';


	// begin(), end()
	cout << "traverse" << '\n';
    // map< string, int >::iterator it; also possible 
	for(auto it = m.begin(); it != m.end(); it++){
		cout << "key : " << it->first << " " << "value : " << it->second << '\n';
	}

	return 0;

}
~~~

참고 블로그 : https://twpower.github.io/91-how-to-use-map-in-cpp <br>
https://blockdmask.tistory.com/87