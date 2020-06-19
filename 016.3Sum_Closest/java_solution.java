//Sort + 2 pointers, 98%
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums==null||nums.length<3) return 0;
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        int minDiff = Math.abs(res - target), lastI = nums[0];
        for(int i = 0; i < nums.length - 2; i++){
            if(i>0 && nums[i] == lastI) continue;
            int l = i+1, r = nums.length-1;
            int currentTarget = target - nums[i];
            while(l < r){
                int currentDiff = Math.abs(currentTarget - nums[l] - nums[r]);
                if(currentDiff < minDiff){
                    minDiff = currentDiff;
                    res = nums[i] + nums[l] + nums[r];
                }
                if(nums[l] + nums[r] < currentTarget){
                    l++;
                }
                else if(nums[l] + nums[r] > currentTarget){
                    r--;
                }
                else return res;
            }
            lastI = nums[i];
        }
        return res;
    }
}
