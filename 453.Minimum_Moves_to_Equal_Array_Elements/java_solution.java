class Solution {
    public int minMoves(int[] nums) {
        int minVal = nums[0], move = 0;
        for (int i: nums) {minVal = Math.min(minVal, i);}
        for (int i: nums) {
            move += i - minVal;
        }
        return move;
    }
}
