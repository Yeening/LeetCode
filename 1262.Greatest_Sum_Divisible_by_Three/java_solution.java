class Solution {
    public int maxSumDivThree(int[] nums) {
        int[] modSums = new int[3];
        for (int cur: nums) {
            int[] nextModSums = Arrays.copyOf(modSums, 3);
            for (int i: modSums) {
                nextModSums[(i+cur) % 3] = 
                    Math.max(modSums[(i+cur) % 3], 
                             modSums[i%3] + cur);
            }
            modSums = nextModSums;
        }
        return modSums[0];
    }
}
