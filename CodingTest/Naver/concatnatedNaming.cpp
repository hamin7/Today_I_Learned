// you can use includes, for example:
#include <algorithm>
#include <string>
#include <vector>
#include <unordered_set>

// you can write to stdout for debugging purposes, e.g.
// cout << "this is a debug message" << endl;

int solution(vector<string>& A){

    int result = 0;
    vector<unordered_set<char>> sets;
        
    for(const auto& s : A){
        unordered_set<char> set;
        bool should_break = false;
            
        for(auto c : s){
            if(set.count(c)){
                should_break = true;
                break;
            }
            
            set.insert(c);
        }
            
        if(!should_break){
            sets.push_back(set);
        }
    }
        
    for(int i = 0; i < sets.size(); ++i){
        auto currSet = sets[i];
            
        for(int j = 0; j < sets.size(); ++j){
            bool should_break = false;
                
            for(auto c : sets[j]){
                if(currSet.count(c)){
                    should_break = true;
                    break;
                }
            }
                
            if(!should_break){
                currSet.insert(sets[j].begin(), sets[j].end());
            }
        }

        result = max(result, int(currSet.size()));
    }
         
    return result;
}


// 문제 : https://www.geeksforgeeks.org/find-the-longest-string-that-can-be-made-up-of-other-strings-from-the-array/
