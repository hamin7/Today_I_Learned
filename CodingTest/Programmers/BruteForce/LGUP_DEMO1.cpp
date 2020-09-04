#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

vector<int> solution(vector<vector<int> > v) {
    vector<int> ans;
    
    int X, Y;
    
    X = v[0][0]^v[1][0]^v[2][0];
    Y = v[0][1]^v[1][1]^v[2][1];

    ans.push_back(X);
    ans.push_back(Y);
    
    return ans;
}