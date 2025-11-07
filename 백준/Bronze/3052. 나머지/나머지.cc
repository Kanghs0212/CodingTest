#include<stdio.h>
#include <iostream>
#include <array>
using namespace std;


int main() {
	int e1=0;
	int res = 0;
	array<int, 42> numbers = {0};
	
	while (cin >> e1)
	{
		numbers[e1 % 42]++;
	}

	for (int i = 0; i < numbers.size(); i++)
	{
		if (numbers[i] > 0)
			res++;
	}
	cout << res << endl;
	return 0;
}