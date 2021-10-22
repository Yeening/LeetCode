class Solution {
    public int integerBreak(int n) {
        int[] maxProduct = new int[n+1];
        maxProduct[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                maxProduct[i] = Math.max(maxProduct[i], 
                                         Math.max(maxProduct[i-j], i - j) * j);
            }
        }
        return maxProduct[n];
    }
}
