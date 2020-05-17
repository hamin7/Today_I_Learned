# Josephus permutation

## Problem

From 1 to N, N people sit in a circle, and a positive integer K (≤ N) is given.
Now remove the Kth person in order.
When one person is removed, the process continues along a circle of remaining people.
This process continues until all N people have been removed.
The order in which people are removed from the circle is called the (N, K) -Josephus permutation.
For example, the (7, 3) -Josephus permutation is < 3, 6, 2, 7, 5, 1, 4 >.

Given N and K, write a program to find the (N, K) -Josephus permutation.

## Input

In the first line, N and K are given in order with spaces between them. (1 ≤ K ≤ N ≤ 5,000)

## Output

Output the Josephus permutation as in the example.

## Example input 1
~~~markdown
7 3
~~~

## Example output 1
~~~markdown
<3, 6, 2, 7, 5, 1, 4>
~~~

## Algorithm classification
- Linked List.

## Example Answer
~~~cpp
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
~~