// you can use includes, for example:
// #include <algorithm>

// you can write to stdout for debugging purposes, e.g.
// cout << "this is a debug message" << endl;

int solution(string & s) {
    int count1 = 0, count2 = 0, s_len = s.length(), answer = 0;
    for (int i = 0; i < s_len; ++i) {
        if (s[i] == 'a') {
            count1++;
        }
        else {
            count2++;
            count1 = 0;
        }
        if (count1 == 3) {
            return -1;
        }
    }
    answer = 2 * (count2 + 1) - (s_len - count2);
    
    return answer;
}
