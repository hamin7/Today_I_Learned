// 소수를 판별하는 함수를 에라토스테네스의 체를 이용하면 더 효율적이다.
#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

// // whether the number is prime number.
// bool isPrime(int num) {
//     bool flag = true;
//     // check from 2 to num's square root.
//     for (int i = 2; i < sqrt(num); i++) {
//         if (num % i == 0)
//             flag = false;
//     }
//     return flag;
// }

bool *primeArr;

// Eratos
void Eratos(int num)
{   
    primeArr = new bool[num+1]; // Allocate array that discriminate prime number
    
    // 0 and 1 is not prime number
    primeArr[0] = false;
    primeArr[1] = false;
    
    // initiallize 2 ~ true
    for(int i=2; i<=num; i++)
        primeArr[i] = true;
    
    for(int i=2; i*i<=num; i++) {
        if(primeArr[i]) // if first one is prime number
            for(int j=i*i; j<=num; j+=i)
                primeArr[j] = false; // multiple of prime number is not prime number
    }
}

// whether the number can be created by "the given numbers".
bool canCreated(int num, string material) {
    // convert "num" from int to string, in order to compare.
    string candidate = to_string(num);
    for (int i = 0; i < candidate.size(); i++) {
        bool flag = false;
        for (int j = 0; j < material.size(); j++) {
            // if candidate number is in material.
            if (candidate.at(i) == material.at(j)) {
                flag = true;
                material.at(j) = ' ';       // substitute used material to blank
                break;
            }
        } if (flag == false) {
            return false;
        }
    }
    return true;
}

int solution(string numbers) {
    int answer = 0;
    
    // sort numbers by descending order
    sort(numbers.begin(), numbers.end(), greater<int>());
    
    // invert string to int by "stoi" function
    int max = stoi(numbers);  
    
    // create array that discriminate prime number.
    Eratos(max);
    // count the prime number that can be created.
    for (int i = 0; i < max+1; i++) {
        // is it prime number? and it can be created?
        if (primeArr[i] && canCreated(i, numbers)){
            answer++;
        }
    }
    
    return answer;
}