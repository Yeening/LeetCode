// power of 2 should contain exactly 1 '1' in its bits
// n & (n - 1) eliminates the last 1
class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        return (n & (n-1)) == 0;
    }
}
