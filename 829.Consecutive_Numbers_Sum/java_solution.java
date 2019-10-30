class Solution {
    public int consecutiveNumbersSum(int N) {
        int count = 0;
        for(int m = 1; ; m++){
            int mx = N - (m*(m-1))/2;
            if(mx <= 0) break;
            if(mx % m == 0) count ++;
        }
        return count;
    }
}
