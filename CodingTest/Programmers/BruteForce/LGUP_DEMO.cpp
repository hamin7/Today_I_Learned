#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

vector<int> solution(vector<vector<int> > v) {
    vector<int> ans;
    int minX, minY, maxX, maxY;
    int minXCnt = 0, maxXCnt = 0, minYCnt = 0, maxYCnt = 0;
    int X, Y;
    
    minX = min(v[0][0], v[1][0]);
    minX = min(minX, v[2][0]);
    
    maxX = max(v[0][0], v[1][0]);
    maxX = max(maxX, v[2][0]);
    
    minY = min(v[0][1], v[1][1]);
    minY = min(minY, v[2][1]);
    
    maxY = max(v[0][1], v[1][1]);
    maxY = max(maxY, v[2][1]);
    
    for (int i = 0; i < 3; i++) {
        if (minX == v[i][0]){
            minXCnt++;
        } else if (maxX == v[i][0]) {
            maxXCnt++;
        }
        if (minY == v[i][1]) {
            minYCnt++;
        } else if (maxY == v[i][1]) {
            maxYCnt++;
        }
    }
    
    if (minXCnt == 1) {
        X = minX;
    } else if (maxXCnt == 1) {
        X = maxX;
    }
    
    if (minYCnt == 1) {
        Y = minY;
    } else if (maxYCnt == 1) {
        Y = maxY;
    }
    
    ans.push_back(X);
    ans.push_back(Y);

    return ans;
}