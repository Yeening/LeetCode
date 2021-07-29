//Approch 1, Time: O(n^3), beat 68.70% submissions
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums.length < 4) return res;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length;) {
            int first = nums[i];
            int j = i + 1;
            while (j < nums.length) {
                int second = nums[j];
                int l = j + 1, r = nums.length - 1;
                while (l < r) {
                    int third = nums[l], forth = nums[r];
                    int sum = first + second + third + forth;
                    if (sum < target) {
                        while (l < r && nums[l] == third) l++;
                    } else if (sum > target) {
                        while (l < r && nums[r] == forth) r--;
                    } else if (sum == target) {
                        res.add(new ArrayList<>(Arrays.asList(first, second, third, forth)));
                        while (l < r && nums[l] == third) l++;
                        while (l < r && nums[r] == forth) r--;
                    }
                }
                while (j < nums.length && nums[j] == second) j++;
            }
            while (i < nums.length && nums[i] == first) i++;
        }
        return res;
    }
}


//Improved recursive approach for k Sum(k>=2) Time O(n^3), beat 94% submittions
class Solution {
    int len = 0;
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        len = nums.length;
        return kSum(nums, target, 0, 4);
    }
    private ArrayList<List<Integer>> kSum(int[] nums, int target, int start, int k)
    {
        ArrayList<List<Integer>> res = new ArrayList<>();
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
