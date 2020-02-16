#include <string>
#include <vector>

using namespace std;

bool connected[200];    // 각각의 컴퓨터가 연결 되었는지 아닌지 나타내는 배열.

void dfs(int index, vector<vector<int>> computers, int num) {
    connected[index] = true;
    for(int i = 0; i < num; i++){
        if(computers[index][i] == 1 && connected[i] == false){
            dfs(i, computers, num);
        }
    }
}

int solution(int n, vector<vector<int>> computers) {
    int answer = 0;

    for (int i = 0; i < n; i++) {
        if(connected[i] == false){
            dfs(i, computers, n);
            answer++;
        }
    }
    return answer;
}
