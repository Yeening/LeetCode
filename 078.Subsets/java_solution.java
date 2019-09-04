//Back tracking solution: 1ms, 45%
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

//DFS solution: 0ms, 100%
//For each num, we can choose it or not
//For choose, add it to every exist lists
//For not choose, do nothing
class Solution {
    public List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for(int num:nums){
            int size = res.size();
            for(int i = 0; i < size; i++){
                List<Integer> temp = new ArrayList<>(res.get(i));
                temp.add(num);
                res.add(temp);
            }
        }
        return res;
    }
}
