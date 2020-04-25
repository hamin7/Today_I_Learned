#include <iostream>
 
using namespace std;
 
int main(void) {
    string str;
    int sum = 0;
 
    cin >> str;
 
    for(int i=0; i<str.length(); i++) {
        sum += str.at(i) - '0';
    }
 
    cout << sum << "\n";
    
    return 0;
}