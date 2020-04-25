# include <iostream>

using namespace std;

int main() {
    int T, n;
    cin >> T;
    for (int i = 0; i < T; i++) {
        int sum = 0;
        for (int j = 0; j < 10; j++) {
            cin >> n;
            if ( n%2 == 1)
                sum += n;
        }
        cout << "#" << i+1 << " " << sum << endl;
    }
}