class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(candidates, 0, target, res, new ArrayList<>());
        return res;
    }
    
    private void backTrack(int[] candidates, int start, int target, 
                          List<List<Integer>> res, List<Integer> cur) {
        if (target == 0) {
            List<Integer> toAdd = new ArrayList<>(cur);
            res.add(toAdd);
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > start && 
                   candidates[i-1] == candidates[i]) {continue;}
            if (candidates[i] > target) {break;}
            cur.add(candidates[i]);
            backTrack(candidates, i + 1, 
                      target - candidates[i], res, cur);
            cur.remove(cur.size() - 1);
            
        }
    }
}
