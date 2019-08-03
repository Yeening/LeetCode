class Solution {
    //Solution1 hash table
    // public int singleNumber(int[] nums) {
    //     Map<Integer, Integer> hash = new HashMap<> ();
    //     for(int i = 0; i < nums.length; i++){
    //         if(hash.containsKey(nums[i])) hash.remove(nums[i]);
    //         else hash.put(nums[i], i);
    //     }
    //     return hash.keySet().iterator().next();
    // }
    ///solution2, using xor
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            res ^= nums[i];
        }
        return res;
    }    
}
