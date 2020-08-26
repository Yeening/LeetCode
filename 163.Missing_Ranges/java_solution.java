class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        int lo = lower;
        List<String> res = new LinkedList<>();
        for(int n: nums){
            if(n > lo){
                if(n == lo + 1){
                    res.add(String.valueOf(lo));
                }
                else{
                    res.add(String.valueOf(lo)+"->"+String.valueOf(n-1));
                }
            }
            lo = n+1;
            if(lo <= lower) return res;
        }
        if(upper == lo){
            res.add(String.valueOf(lo));
        }
        else if(upper > lo){
            res.add(String.valueOf(lo)+"->"+String.valueOf(upper));
        }
        return res;
    }
}
