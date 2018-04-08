class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        //Make a hash map that uses num as key and position of the num as its value
        unordered_map<int,int> hash;
        for(int i = 0; i < nums.size(); i++){
            int num_to_find = target - nums[i];
            //Found the target num 
            //There's no need to judge if it's the same element, because of the sequence of insert
            if(hash.find(num_to_find) != hash.end()){
                vector<int> result = {hash[num_to_find], i};
                return result;
            }
            else hash[nums[i]] = i;
            
        }
    }
};
