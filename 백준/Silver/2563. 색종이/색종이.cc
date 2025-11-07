#include<stdio.h>
#include <iostream>
#include <string>
#include <array>
using namespace std;

int main() {
	int c = 0, x, y;
	array<array<int, 100>, 100> background = { 0 };
	cin >> c;

	while (cin >> x >> y)
	{
		for (int i = x; i < x+10; i++)
		{
			for (int j = y; j < y+10; j++)
			{
				background[i][j] ++;
			}
		}
	}

	int result = 0;
	for (int i = 0; i < 100; i++)
	{
		for (int j = 0; j < 100; j++)
		{
			if (background[i][j] > 0)
				result++;
		}
	}

	cout << result;
	return 0;
}