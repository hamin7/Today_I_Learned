#include <iostream>
#include <vector>
using namespace std;

int main() {
	int n, m, idx = 0, cnt;
	vector<int> nums;

	cin >> n >> m;
	// nums 벡터 초기화: 1~n까지 순서대로 삽입
	for (int i = 1; i <= n; i++)
		nums.push_back(i);

	idx = m - 1;
	cout << "<";
	while (nums.size() > 1) {
		cout << nums[idx] << ',' << ' ';
		nums.erase(nums.begin() + idx);
		idx += m - 1;
		idx %= nums.size();
	}
	cout << nums[0] << '>' << '\n';

	return 0;
}