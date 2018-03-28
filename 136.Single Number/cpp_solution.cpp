#include<nurmeric>  //for solution2
#include<map>       //for solution3

class Solution {
public:
    int singleNumber(vector<int>& nums) {
        /*solution1: XOR*/
        int res = 0;
        for(int i = 0; i < nums.size(); i++){
            res ^= nums[i];
        }
        return res;
        /*solution 2: Math*/
        /*set<int> nums_noredonant;
        for(int i = 0; i < nums.size(); i++){
            nums_noredonant.insert(nums[i]);
        }
        return 2 * accumulate(nums_noredonant.begin(),nums_noredonant.end(),0) - accumulate(nums.begin(),nums.end(),0);*/
        /*solution3: Map*/
        /*map<int,int> counts;
        for(int i = 0; i < nums.size(); i++){
            counts[nums[i]]++;
        }
        map<int,int>::iterator ite;
        for(ite = counts.begin(); ite != counts.end(); ite++){
            if( ite->second == 1 ) return ite->first;
        }*/
    }
};
