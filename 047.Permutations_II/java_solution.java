class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backTracking(nums, used, new ArrayList<>(), res);
        return res;
    }
    private void backTracking(int[] nums,boolean[] used, ArrayList<Integer> temp
                              , List<List<Integer>> res){
        if(temp.size()==nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i  = 0; i < nums.length; i++){
            //If the duplicated num's previous num is not used, then it cannot be used
            if(used[i] || (i>0 && nums[i]==nums[i-1] && !used[i-1])) continue;
            temp.add(nums[i]);
            used[i] = true;
            backTracking(nums,used, temp, res);
            temp.remove(temp.size() - 1);
            used[i] = false;                
            
        }
    }
}
