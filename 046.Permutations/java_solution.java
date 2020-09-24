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

// By using swap, we can skip using list.contians or new a Set
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        backTracking(nums, new ArrayList<>(), 0, res);
        return res;
    }
    
    private void backTracking(int[] nums, List<Integer> tmp, int start, List<List<Integer>> res){
        if(tmp.size() == nums.length){
            res.add(new ArrayList<Integer>(tmp));
            return;
        }
        for(int i = start; i < nums.length; i++){
            tmp.add(nums[i]);
            swap(nums, i, start);
            backTracking(nums, tmp, start+1, res);
            tmp.remove(tmp.size()-1);
            swap(nums, i, start);
        }
    }
    
    private void swap(int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
