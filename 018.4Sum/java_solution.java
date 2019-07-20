//Approch 1, Time: O(n^3), beat 68.70% submissions
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for(int i = 0; i < nums.length - 2; i++){
            if(i > 0 && nums[i-1] == nums[i]) continue;
            int target1 = target - nums[i];
            for(int j = i + 1; j < nums.length - 1; j++){
                if(j> i + 1 && nums[j - 1] == nums[j]) continue;
                int target2 = target1 - nums[j];
                int lo = j + 1, hi = nums.length - 1;
                while(lo<hi){
                    if(nums[lo] + nums[hi] == target2){
                        res.add(Arrays.asList(nums[i], nums[j], nums[lo], nums[hi]));
                        while(lo < nums.length - 1 && nums[lo + 1] == nums[lo]) lo++;
                        while(hi > j && nums[hi - 1] == nums[hi]) hi--;
                        lo++;
                        hi--;
                    }
                    else if(nums[lo] + nums[hi] < target2) lo++;
                    else hi--;
                }
            }
            
        }
        return res;
    }
}
