// explanation: https://labuladong.gitbook.io/algo/mu-lu-ye-3/mu-lu-ye-2/jie-cheng-ti-mu
class Solution {
    public int trailingZeroes(int n) {
        int zeros = 0, divisor = 5;
        while (n >= divisor) {
            zeros += (n / divisor);
            divisor *= 5;
        }
        return zeros;
    }
}
