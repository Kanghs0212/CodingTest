#include<stdio.h>
#include <iostream>
#include<deque>
using namespace std;

int main() {
	int n;
	deque<int> dq;
	
	cin >> n;

	for (int i = 1; i <= n; i++)
	{
		dq.push_back(i);
	}

	while (dq.size() > 1) 
	{
		cout << dq.front() << " "; dq.pop_front();
		if (dq.size() == 1) break;
		dq.push_back(dq.front()); dq.pop_front();
	}
	cout<< dq.front();
	return 0;
}