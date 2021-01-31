class Solution {
    public int subarraysDivByK(int[] A, int K) {
        if(A == null || A.length == 0) return 0;
        int[] preSumRemainders = new int[K];
        preSumRemainders[0] = 1;
        int preSum = 0, count = 0;
        for(int i: A) {
            preSum += i;
            int remainder = (preSum%K + K) % K;
            count += preSumRemainders[remainder];
            preSumRemainders[remainder]++;
        }
        return count;
    }
}
