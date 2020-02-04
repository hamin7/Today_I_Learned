#include <string>
#include <vector>
#include <queue>

using namespace std;

int solution(int stock, vector<int> dates, vector<int> supplies, int k) {
    int answer = 0;
    
    priority_queue<int> big_order;
    
    int index = 0;
    for(int day=0; day<k; day++){
        if(day == dates[index]){    // 공급되는 날이라면.
            big_order.push(supplies[index]);    // 공급량을 big_order에 추가.
            index++;    // index는 무슨 역할?
        }
        if(stock == 0){
            stock = big_order.top();    // top에 있는 원소 반환
            big_order.pop();
            answer++;
        }
        stock--;
    }
    return answer;
}