#include <string>
#include <vector>
#include <iostream>
#include <queue>
#include <cstdio>

using namespace std;

int dist(int startX, int startY, int destX, int destY) {
    int distX = 0;
    int distY = 0;
    
    if (startX > destX) {
        distX = startX - destX;
    } else {
        distX = destX - startX;
    }
    
    if (startY > destY) {
        distY = startY - destY;
    } else {
        distY = destY - startY;
    }
    
    int dist = distX + distY;
    return dist;
}

string solution(vector<int> numbers, string hand) {
    string answer = "";
    
    int leftHandX = 0;      // 왼손 x좌표
    int leftHandY = 0;      // 왼손 y좌표
    int rightHandX = 2;     // 오른손 x좌표
    int rightHandY = 0;     // 오른손 y좌표
    
    // numbers의 길이만큼 반복.
    for (int i = 0; i < numbers.size(); i++){
        if (numbers[i] == 1){
            answer.append("L");
            leftHandX = 0;      // 왼손 x좌표
            leftHandY = 3;      // 왼손 y좌표
        } else if (numbers[i] == 4 ) {
            answer.append("L");
            leftHandX = 0;      // 왼손 x좌표
            leftHandY = 2;      // 왼손 y좌표
        } else if (numbers[i] == 7) {
            answer.append("L");
            leftHandX = 0;      // 왼손 x좌표
            leftHandY = 1;      // 왼손 y좌표
        } else if (numbers[i] == 3){
            answer.append("R");
            rightHandX = 2;      // 오른손 x좌표
            rightHandY = 3;      // 오른손 y좌표
        } else if (numbers[i] == 6) {
            answer.append("R");
            rightHandX = 2;      // 오른손 x좌표
            rightHandY = 2;      // 오른손 y좌표    
        } else if (numbers[i] == 9) {
            answer.append("R");
            rightHandX = 2;      // 오른손 x좌표
            rightHandY = 1;      // 오른손 y좌표
        } else if (numbers[i] == 2) {
            int distLeft = dist(leftHandX, leftHandY, 1, 3);
            int distRight = dist(rightHandX, rightHandY, 1, 3);
            
            if (distLeft < distRight) {
                answer.append("L");
                leftHandX = 1;
                leftHandY = 3;
            } else if (distRight < distLeft) {
                answer.append("R");
                rightHandX = 1;
                rightHandY = 3;
            } else {
                if (hand == "left"){
                    answer.append("L");
                    leftHandX = 1;
                    leftHandY = 3;
                } else {
                    answer.append("R");
                    rightHandX = 1;
                    rightHandY = 3;
                }
            }
        } else if (numbers[i] == 5) {
            int distLeft = dist(leftHandX, leftHandY, 1, 2);
            int distRight = dist(rightHandX, rightHandY, 1, 2);

            if (distLeft < distRight) {
                answer.append("L");
                leftHandX = 1;
                leftHandY = 2;
            } else if (distRight < distLeft) {
                answer.append("R");
                rightHandX = 1;
                rightHandY = 2;
            } else {
                if (hand == "left"){
                    answer.append("L");
                    leftHandX = 1;
                    leftHandY = 2;
                } else{
                    answer.append("R");
                    rightHandX = 1;
                    rightHandY = 2;
                } 
            }
        } else if (numbers[i] == 8) {
            int distLeft = dist(leftHandX, leftHandY, 1, 1);
            int distRight = dist(rightHandX, rightHandY, 1, 1);
            
            if (distLeft < distRight) {
                answer.append("L");
                leftHandX = 1;
                leftHandY = 1;
            } else if (distRight < distLeft) {
                answer.append("R");
                rightHandX = 1;
                rightHandY = 1;
            } else {
                if (hand == "left"){
                    answer.append("L");
                    leftHandX = 1;
                    leftHandY = 1;
                } else{
                    answer.append("R");
                    rightHandX = 1;
                    rightHandY = 1;
                } 
            }
            
        } else if (numbers[i] == 0) {
            int distLeft = dist(leftHandX, leftHandY, 1, 0);
            int distRight = dist(rightHandX, rightHandY, 1, 0);
            
            if (distLeft < distRight) {
                answer.append("L");
                leftHandX = 1;
                leftHandY = 0;
            } else if (distRight < distLeft) {
                answer.append("R");
                rightHandX = 1;
                rightHandY = 0;
            } else {
                if (hand == "left"){
                    answer.append("L");
                    leftHandX = 1;
                    leftHandY = 0;
                } else{
                    answer.append("R");
                    rightHandX = 1;
                    rightHandY = 0;
                } 
            }
        }
    }
    
    return answer;
}