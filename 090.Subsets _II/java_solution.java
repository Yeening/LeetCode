class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());
        int start = 1;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            int size = res.size();
            int j = 0;
            //For repreated nums
            if(i > 0 && nums[i] ==nums[i-1]) {j = start;}
            for(; j < size; j++){
                List<Integer> temp = new ArrayList<>(res.get(j));
                temp.add(nums[i]);
                res.add(temp);
            }                
            start = size;
        }
        return res;
    }
}
