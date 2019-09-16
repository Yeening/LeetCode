class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        backTracking(nums, new ArrayList<Integer>(), res);
        return res;
    }
    private void backTracking(int[] nums, ArrayList<Integer> temp, List<List<Integer>> res){
        //List uses size()
        if(temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            //Array List contains(Object)
            if(temp.contains(nums[i])) continue;
            temp.add(nums[i]);
            backTracking(nums, temp, res);
            //Remove the last element
            temp.remove(temp.size()-1);
        }
    }
}
