// solution 1: dp
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

// solution 2: math, try to get 3 then 2
class Solution {
    public int integerBreak(int n) {
        if (n < 4) {
            int[] fixedValue = new int[]{0,1,1,2};
            return fixedValue[n];
        }
        int remain3 = n % 3;
        int count3 = n / 3;
        if (remain3 == 0) {
            return (int)Math.pow(3, count3);
        } else if (remain3 == 1){
            return (int)Math.pow(3, count3 - 1) * 4;
        } else if (remain3 == 2) {
            return (int)Math.pow(3, count3) * 2;
        }
        return 0;
    }
}
