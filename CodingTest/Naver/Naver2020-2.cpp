#include <iostream>
#include <vector>
using namespace std;
int main()
{
    //입력
    int arr[5][2] = {{0, 92}, {1,20}, {2, 11}, {1,-81}, {3,98}};
    
    int pyramid[15][15];
    int size = 5;//몇층인지 구하고
    
    pyramid[0][0] = arr[0][1];
    for(int i=1; i<size; i++){
        int block = arr[i][0];  //답나와 있는 블록이 몇번째인지
        pyramid[i][block] = arr[i][1];
        
        //block왼쪽방향으로 채우기
        for(int j=block-1; j>=0; j--){
            pyramid[i][j] = pyramid[i-1][j] - pyramid[i][j+1];
        }
        //block오른쪽방향으로 채우기
        for(int j=block+1; j<=i; j++){
            pyramid[i][j] = pyramid[i-1][j-1] - pyramid[i][j-1];
        }
    }
    
    vector<int> answer;
    for(int i=0; i<size;i++){
        for(int j=0; j<=i;j++)
            answer.push_back(pyramid[i][j]);
    }
    for(int i=0; i<answer.size();i++)
        cout << answer[i] <<" ";

    return 0;
}