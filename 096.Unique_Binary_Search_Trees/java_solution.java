class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = dp[1] = 1;
        for(int i = 2; i <= n; i++){
            for(int j = 0; j < i; j++){
                dp[i] += dp[j] * dp[i-1-j];
            }
        }
        return dp[n];
    }
}

// Solution 2: memo recursion
class Solution {
    int[][] memo;
    int N;
    public int numTrees(int n) {
        N = n;
        memo = new int[N][N];
        return numTreesInterval(0, n-1);
    }

    private int numTreesInterval(int l, int r){
        if (l > r) {
            return 1;
        }
        if (memo[l][r] != 0) {
            return memo[l][r];
        }
        int count = 0;
        for(int i = l; i <= r; i++) {
            count += numTreesInterval(l, i - 1) * numTreesInterval(i + 1, r);
        }
        memo[l][r] = count;
        return count;
    }
}
