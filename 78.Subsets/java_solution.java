//Back tracking solution
class Solution {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        backTrack(res, new LinkedList<Integer>(), 0, nums);
        return res;
    }
    private void backTrack(List<List<Integer>> res, LinkedList<Integer> temp, int start, int[] nums){
        res.add(new LinkedList<Integer>(temp));
        for(int i = start; i < nums.length; i++){
            //For each num, add it to temp and reduce the problem to nums from i + 1 to end
            temp.add(nums[i]);
            backTrack(res, temp, i+1, nums);
            //Then, remove it and start form next num
            temp.removeLast();
        }
    }
}
