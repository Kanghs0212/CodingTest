#include<stdio.h>
#include <iostream>
#include<queue>
using namespace std;

int main() {
	int n;
	priority_queue<int> pq;

	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> n;

	while (cin >> n) 
	{
		if(n==0)
		{
			if (pq.empty())
				cout << 0 << "\n";
			else {
				cout << pq.top() << "\n";
				pq.pop();
			}
		}
		pq.push(n);
	}
	return 0;
}