class Solution {
    
    int[] nums;
    Random random;
    int size;

    public Solution(int[] nums) {
        this.nums = nums;
        size = nums.length;
        random = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return this.nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] temp = nums.clone();
        for(int i = 0; i < size; i++){
            int j = random.nextInt(size);
            int mid = temp[i];
            temp[i] = temp[j];
            temp[j] = mid;
        }
        return temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
