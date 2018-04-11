//Looping Binary Search
class Solution {
public:
    int search(vector<int>& nums, int target) {
        //if(!nums.size()) return -1;
        int low = 0, high = nums.size()-1;
        while(low <= high){
            int mid = (low + high)/2;
            if(nums[mid] == target) return mid;
            //first half in correct order
            if(nums[low] <= nums[mid]){
                if(target < nums[mid] && target >= nums[low]){ high = mid - 1;}
                else low = mid + 1;
            }
            //second half in correct order
            else{
                if(target > nums[mid] && target <= nums[high]){low = mid + 1;}
                else high = mid - 1;
            }
            
        }
        //high equals to low
        //if(target == nums[high]) return high;
        return -1;
    }
};
