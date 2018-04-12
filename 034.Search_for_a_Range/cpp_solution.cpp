//My solution - recursive, 12ms
class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        vector<int> result(2,-1);
        searchRange(nums, target, result, 0, nums.size()-1);
        return result;
    }
private:
    void searchRange(vector<int>& nums, int target, vector<int>& result, int lo, int hi){
        if(lo <= hi){
            int mid = (lo + hi)/2;
            if(nums[mid] == target){
                if(mid <= result[0] || result[0] < 0) result[0] = mid;
                if(mid >= result[1]) result[1] = mid;
            }
            if(target >= nums[lo] && target <= nums[mid]){
                searchRange(nums, target, result, lo, mid-1);
            }
            if(target >= nums[mid] && target <= nums[hi]){
                searchRange(nums, target, result, mid+1, hi);
            }
        }
        return;
    }
};

//Iterative solution with two binary searches -12ms
class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        vector<int> res(2, -1);
        if(!nums.size()) return res;
        int lo = 0, hi = nums.size() - 1;
        //find left
        while(lo < hi){
            int mid = (lo + hi)/2;
            if(nums[mid] < target) lo = mid + 1;
            else hi = mid;
        }
        if(nums[lo] != target) return res;
        else res[0] = lo;
        hi = nums.size() -1;
        while(lo < hi){
            int mid = (lo + hi)/2 +1;  // Make mid biased to the right
            if(nums[mid] > target) hi = mid -1;
            else lo = mid;
        }
        res[1] = lo;
        return res;
        
    }
};
