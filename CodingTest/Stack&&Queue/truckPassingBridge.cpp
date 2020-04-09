#include <string>
#include <vector>
#include <queue>

using namespace std;

int solution(int bridge_length, int weight, vector<int> truck_weights) {
    int answer = 0; // 총 걸린시간.
    int sum = 0;    // 다리 위에 있는 트럭들의 무게 합.
    int truckIdx = 0;   // 트럭의 인덱스.
    queue<int> truckStart;  // 트럭이 출발하는 시점들.
    queue<int> onBridge;    // 다리 위에 있는 트럭의 무게들.

    while(true){
        answer++; // 시간 증가.

        // 현재 시간 - 다리 위 젤 앞 트럭 출발 시간 == 다리길이 -> 트럭 도착
        if(answer - truckStart.front() == bridge_length){
            sum -= onBridge.front();   // 다리위 트럭 무게합에서 도착한 트럭 무게 pop.
            onBridge.pop(); // 다리 위에 있는 트럭의 무게에서 pop.
            truckStart.pop();   // 트럭 출발 시간 pop.
        }

        // 트럭의 무게가 다리의 무게보다 작으면, 트럭을 삽입.
        if(sum + truck_weights[truckIdx] <= weight){
            // 마지막 트럭이 삽입되면 종료
            if(truckIdx == truck_weights.size()-1){
                // 마지막 트럭 도착시간 추가.
                answer += bridge_length;
                break;
            }
            onBridge.push(truck_weights[truckIdx]);    // 다리 위에 있는 트럭의 무게 추가.
            truckStart.push(answer);  // 트럭이 출발하는 시간 push.
            sum += truck_weights[truckIdx]; // 다리위에 있는 트럭의 무게 합.
            truckIdx++; // 트럭 인덱스 추가.
        }
    }

    return answer;
}
