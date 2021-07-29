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

// Solution 2
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums.length < 3) return res;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; ) {
            int cur = nums[i];
            for (List<Integer> pair: twoSum(nums, i+1, -cur)) {
                pair.add(cur);
                res.add(pair);
            }
            while (i < nums.length && nums[i] == cur) i++;
        }
        return res;
    }
    
    private List<List<Integer>> twoSum(int[] nums, int start, int target) {
        List<List<Integer>> res = new LinkedList<>();
        int l = start, r = nums.length - 1;
        while (l < r) {
            int lVal = nums[l], rVal = nums[r];
            int sum = lVal + rVal;
            if (sum < target) {
                while (l < r && nums[l] == lVal) l++;
            } else if (sum > target) {
                while (r > l && nums[r] == rVal) r--;
            } else if (sum == target){
                res.add(new ArrayList<>(Arrays.asList(nums[l], nums[r])));
                while (l < r && nums[l] == lVal) l++;
                while (r > l && nums[r] == rVal) r--;
            }
        }
        return res;
    }
}
