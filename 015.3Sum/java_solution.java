class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            if(nums[i] + nums[i + 1] > 0) break;
            if(i == 0 || nums[i - 1] != nums[i]){
                int lo = i + 1, hi = nums.length - 1, target = 0 - nums[i];
                while(lo < hi){
                    if(nums[lo] + nums[hi] == target){
                        res.add(Arrays.asList(nums[i],nums[lo], nums[hi]));
                        while(lo<nums.length - 1 && nums[lo+1] == nums[lo])                               
                            lo++;
                        while(hi>0 && nums[hi-1] == nums[hi]) 
                            hi--;
                        lo++;
                        hi--;
                    }
                    else if(nums[lo] + nums[hi] < target){
                        /*This will waste time when there are not much deplicates*/
                        // while(lo<nums.length - 1 && nums[lo+1] == nums[lo])                               
                        //  lo++;
                        lo++;
                    } 
                    else{
                        // while(hi>0 && nums[hi-1] == nums[hi]) 
                        //   hi--;
                        hi--;
                    } 
                }
            }
        }
        return res;
    }
}
