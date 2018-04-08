#include<iostream>
#include<unordered_map>
#include<vector>

using namespace std;
vector<int> twoSum(vector<int> &numbers, int target) {
	unordered_map<int, int> hash;
	vector<int> result;
	for (int i = 0;i < numbers.size();i++) {
		int numToFind = target - numbers[i];
		//If find, return the result.
		if (hash.find(numToFind) != hash.end()) {
			result.push_back(hash[numToFind]);
			result.push_back(i);
		}
		//else add the number asn its position to the hashmap.
		hash[numbers[i]] = i;
	}
	return result;
}
int main() {
	vector<int> result;
	vector<int> numbers = { 2, 7, 11, 15 };
	int target = 9;
	result = twoSum(numbers, target);
	for (int i = 0;i < result.size();i++) {
		cout << result[i] << " ";
	}
	cout << endl;
	return 0;
}
