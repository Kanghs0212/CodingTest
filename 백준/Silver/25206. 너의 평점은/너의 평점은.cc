#include<stdio.h>
#include <iostream>
#include <string>
#include <unordered_map>
using namespace std;

int main() {
	string subject, grade;
	float point,total_point=0, total_grade = 0;
	unordered_map<string, float> dict = { 
		{"A+",4.5}, {"A0", 4.0}, {"B+",3.5}, {"B0",3.0},
		{"C+", 2.5}, {"C0", 2.0}, {"D+",1.5}, {"D0",1.0}, {"F", 0.0}
	};

	while (cin >> subject >> point >> grade) 
	{
		if (grade != "P") {
			total_point += point;
			total_grade += point * dict[grade];
		}
	}

	cout << total_grade / total_point << endl;

	return 0;
}