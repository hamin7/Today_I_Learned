#include <string>
#include <vector>
#include <map>

using namespace std;

int solution(vector<vector<string>> clothes) {
    int answer = 1;
    map<string,int> clothType;  // 의상 종류 : 옷의 갯수 해시 생성.

    for (int i = 0; i < clothes.size(); i++){
        auto & c = clothes[i];
        auto & body = c[1];
        if(clothType.find(body) == clothType.end()){
            clothType[body] = 0;
        }
        clothType[body]++;
    }
    // 범위 기반의 for문. clothes의 각 배열을 c에 참조.
    // for (const auto & c : clothes) {
    //     const auto & body = c[1];   // c[1]이니 의상의 타입을 body에
    //     clothType[body] = (clothType.find(body) == clothType.end() ? 0 : clothType[body]) + 1;
    // }

    // 경우의 수 알고리즘 사용.
    for (auto & set : clothType) {
        answer *= (set.second + 1);     // 실제 갯수 보다 + 1 (안 입은 것도 포함)
    }

    return answer - 1;
}
