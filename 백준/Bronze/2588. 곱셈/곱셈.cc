#include<stdio.h>
#include <iostream>
#include<string>
using namespace std;


int main() {
	int multiplicand;
	string multiplier;

	cin >> multiplicand;
	cin >> multiplier;

	for (int i = multiplier.size()-1; i >=0; i--)
	{
		int c = multiplier[i] - '0';

		cout << multiplicand * c << endl;
	}

	cout << stoi(multiplier) * multiplicand << endl;


	return 0;
}