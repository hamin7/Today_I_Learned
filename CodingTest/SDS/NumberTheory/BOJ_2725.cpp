#include <bits/stdc++.h>
using namespace std;
const int MAX = 1000;

int C, N;
int dp[MAX+1];    // dp[x] = x번째 보이는 점들의 총 개수
bool visited[MAX+1][MAX+1];

int GCD(int x, int y){
	if(y==0) return x;
	return GCD(y,x%y);
}

// 기울기로 보이는 점 판별
void MakeDP(int curr){
	if(curr>MAX) return;
	// 추가로 보이는 수 구하기
	int ADD = 0;
	// 반쪽만 구해서 2배.
	for(int i=1; i<curr; ++i){
		int x = i;
		int y = curr;
		// y/x = (y/g)/(x/g) 기약분수 만들기
		int g = GCD(y,x);
		x /= g;
		y /= g;
		if(visited[y][x]) continue;
		ADD++;
		visited[y][x] = true;
	}
	
    // curr번째 총 개수 = curr-1번째 총 개수 + 추가로 보이는 수
	dp[curr] = dp[curr-1]+2*ADD;
	MakeDP(curr+1);
}
int main(){ios_base::sync_with_stdio(false); cout.tie(NULL); cin.tie(NULL);

cin>>C;
dp[1] = 3;
visited[1][1] = true;
MakeDP(2);
while(C--){
	cin >> N;
	cout << dp[N] << '\n';	
}

return 0;
}