#include<stdio.h>
#include <iostream>
#include<string>
using namespace std;


int main() {
	int e1=0;
	int e2=0;
	int e3=0;
	string input;

	cin >> e1 >> e2 >> e3;

	if (e1 == e2 && e2 == e3) {
		cout << 10000 + e1 * 1000;
	}
	else if (e1 == e2) {
		cout << 1000 + e1 * 100;
	}
	else if (e3 == e2) {
		cout << 1000 + e2 * 100;
	}
	else if (e1 == e3) {
		cout << 1000 + e3 * 100;
	}
	else {
		cout << max( max(e1, e2), e3 ) * 100;
	}
	
	return 0;
}