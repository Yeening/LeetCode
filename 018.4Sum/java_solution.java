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


//Improved recursive approach for k Sum(k>=2)
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        // List<List<Integer>> res = new LinkedList<>();
        
        return kSum(nums, target, 0, 4);
    }
    private ArrayList<List<Integer>> kSum(int[] nums, int target, int start, int k)
    {
        ArrayList<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if(start > len - k || nums[start] * k > target || nums[len-1]*k < target) return res;
        if(k==2){
            int lo = start, hi = len-1;
            while(lo<hi){
                if(nums[lo] + nums[hi] == target){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[lo]);
                    temp.add(nums[hi]);
                    res.add(temp);
                    // res.add(Arrays.asList(nums[lo],nums[hi]));
                    // This cannot work because the return type of Arrays.asList is Arrays$ArrayList, cannot be added with element
                    while(lo < hi && nums[lo] == nums[lo+1]) lo++;
                    while(hi > lo &&nums[hi-1] == nums[hi]) hi--;
                    lo++;
                    hi--;
                }
                else if(nums[lo] + nums[hi] < target) lo++;
                else hi--;
            }
        }
        else{
            for(int i = start; i < len - k + 1; i++){
                if(i > start && nums[i-1] == nums[i]) continue;
                ArrayList<List<Integer>> temp = kSum(nums, target - nums[i], i + 1, k-1);
                if(temp != null){
                    for(List<Integer> t : temp){
                        t.add(0, nums[i]);
                    }   
                    res.addAll(temp);
                }                
            }
        

        }
        return res;
    }
}
