#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int N, K;
vector <string> words;
bool visited[26];		// 방문 체크
int selectedCount = 0;		// 총 몇 개의 알파벳을 내가 선택했는지.
int maxReadable = 0;		// 최대로 읽을 수 있는 단어의 갯수.

// 현재 내가 읽을 수 있는 단어의 갯수 count.
// 단어들을 순회하면서 읽을 수 있는가를 체크.
int countWords() {
	int count = 0;
	for (int i = 0; i < N; i++) {
		bool isPossible = true;
		string word = words[i];
		// 한 단어의 길이만큼 돌아주기.
		
		for (int j = 0; j < sizeof(word); j++) {
			// j번째 char를 가져옴. 그것을 숫자로 바꿔주기.
			// 해당 알파벳을 배운적이 없으면...
			if(visited[word.at(i) - 'a'] == false) {
				isPossible = false;
				break;
			}
		}
		// 읽을 수 있는 단어.
		if(isPossible == true) {
			count++;
		}
	}
	return count;
}

// 파라미터는 상태정보, 내가 현재 고른 알파벳은 무엇인가..
// DFS는 사람이 손으로 푸는 것과 비슷한 매커니즘.
void dfs(int index) {
	// 1. 체크인
	visited[index] = true;
	selectedCount++;
	// 2. 목적지인가?
	// selectedCount == K => 최대개수 계산
	if (selectedCount == K) {
		// maxReadable = 최대 단어 개수. 읽을 수 있는 최댓값.
		maxReadable = max(countWords(),maxReadable);
	} else {
		// 최대 단어의 개수만큼 찾지 못함
		// 3. 갈 수 있는 곳을 순회
		// 알파벳이 26개 이니까 26까지 감.
		for (int i = index + 1; i < 26; i++) {
			// 4. 갈 수 있는가?
			if(visited[i] == false) {
				// 5. 간다 dfs(next)
				dfs(i);
			}
		}
	}
	// 6. 체크아웃
	// 체크인과 체크아웃의 indent가 동일해야...
	visited[index] = false;
	selectedCount--;
}

int main() {
	cin >> N >> K;
	
	visited['a' - 'a'] = true;
	visited['n' - 'a'] = true;
	visited['t' - 'a'] = true;
	visited['i' - 'a'] = true;
	visited['c' - 'a'] = true;
	
	selectedCount = 5;
	
	for (int i = 0; i < N; i++) {
		string s; cin >> s;
		// 중복되는 글자들을 공백으로 바꾸기(anta, tica 제거)
		s.erase(s.begin(), s.begin() + 4);
		s.erase(s.end() - 4, s.end());
		words.push_back(s);
	}
	
	selectedCount = 5;
	
	if (K < 5) {
		// K의 갯수가 5보다 작다면 읽을 수 있는 단어가 없음.
		maxReadable = 0;
	} else {
		maxReadable = countWords();
	}
	
	// 알파벳 a부터 시작하여 고르기.
	for (int i = 0; i < 26; i++) {
		// 아직 선택되지 않은 경우.
		if(visited[i] == false) {
			dfs(i);
		}
	}
	
	cout << maxReadable << endl;
	
	return 0;
}