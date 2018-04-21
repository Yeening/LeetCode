class Solution {
public:
    bool canJump(vector<int>& nums) {
        int reach = 0, len = nums.size();
        for(int i = 0; i < len - 1 && i <= reach; i++){
            reach = max(reach, nums[i] + i);
        }
        return reach >= len - 1;
    }
};
