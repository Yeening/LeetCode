class Solution {
    public boolean isPowerOfThree(int n) {
        // Find the max integer that is a power of 3, 3^19
        int maxPow3 = (int) Math.pow(3, (int)(Math.log((double)Integer.MAX_VALUE) / Math.log(3)));
        return n > 0 && maxPow3 % n == 0;
    }
}
