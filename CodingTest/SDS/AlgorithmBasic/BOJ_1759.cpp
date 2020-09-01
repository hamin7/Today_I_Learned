#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int L, C;
char data[16];
vector <char> pwd;

void dfs(int length, int con, int vow, int current, vector<char> pwd) {
//		1. 체크인 - 생략 가능.
//		2. 목적지인가? => if (length == L) => 자음, 모음 개수 확인 => 맞으면 저장.
	// 단어 길이가 충족 되는가?
	if (length == L) {
		if (con >= 2 && vow >= 1) {
			// 답 발견. 출력 or 저장.
			for (int i = 0; i < L; i++) {
				cout << pwd[i];
			}
			cout << endl;
			return;
		}
	} else {
//		3. 갈 수 있는 곳을 순회 => for ( current + 1 - C - 1)
		for (int i = current + 1; i < C; i++) {
//			4. 	갈 수 있는가? - 생략가능.
//			5. 		간다 - dfs(next)
			if(data[i] == 'a' || data[i] == 'e' || data[i] == 'i' || data[i] == 'o' || data[i] == 'u') {
				// 모음 갯수 1개 증가.
				pwd.push_back(data[i]);
				dfs(length + 1, con, vow + 1, i, pwd);
			} else {
				// 자음 갯수 1개 증가.
				pwd.push_back(data[i]);
				dfs(length + 1, con + 1, vow, i, pwd);
			}
			pwd.pop_back();
		}
	}
//		6. 체크아웃 - 생략가능.
}

int main() {
	cin >> L >> C;
	
	for (int i = 0; i < C; i++) {
		cin >> data[i];
	}
	
	sort(data, data + C);		// 오름차순 정렬.
	
	// 호출은 보통 모든 시작점에 대해서 해줘야 함.
	for (int i = 0; i < C; i++) {
		if (data[i] == 'a' || data[i] == 'e' || data[i] == 'i' || data[i] == 'o' || data[i] =='u') {
			pwd.push_back(data[i]);
			dfs(1, 0, 1, i, pwd);
		} else {
			pwd.push_back(data[i]);
			dfs(1, 1, 0, i, pwd);
		}
		pwd.pop_back();
	}
	
// 	가상의 시작점을 두고 dfs를 시작하는 방법!
// 	dfs(0, 0, 0, -1, "");
}