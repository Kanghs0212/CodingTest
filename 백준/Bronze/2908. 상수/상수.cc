#include<stdio.h>
#include <iostream>
#include <string>
using namespace std;

int main() {
	string e1,e2;

	cin >> e1 >> e2;
	swap(e1[0], e1[2]); swap(e2[0], e2[2]);
	cout << max(stoi(e1), stoi(e2)) << endl;

	return 0;
}