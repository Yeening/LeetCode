class Solution {
    public int preimageSizeFZF(int k) {
        long left = 0, right = Long.MAX_VALUE;
        long floor = 0, ceiling = 0;
        while (left <= right) {
            long mid = left + (right - left >> 1);
            long cur = trailingZeroes(mid);
            if (cur < k) {
                left = mid + 1;
            } else if (cur > k) {
                right = mid - 1;
            } else if (cur == k) {
                right = mid - 1;
            }
        }
        if (trailingZeroes(left) != k) return 0;
        floor = left;
        right = Long.MAX_VALUE;
        while (left <= right) {
            long mid = left + (right - left >> 1);
            long cur = trailingZeroes(mid);
            if (cur < k) {
                left = mid + 1;
            } else if (cur > k) {
                right = mid - 1;
            } else if (cur == k) {
                left = mid + 1;
            }
        }
        ceiling = right;
        return (int) (ceiling - floor + 1);
    }

    public long trailingZeroes(long n) {
        long zeros = 0;
        while (n >= 5l) {
            zeros += (n / 5l);
            n /= 5l;
        }
        return zeros;
    }
}
