// Explaination: https://labuladong.gitbook.io/algo/mu-lu-ye/er-fen-cha-zhao-xiang-jie
// find left boundary using binary search

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 0;
        for (int p: piles) {
            right = Math.max(right, p);
        }
        while (left <= right) {
            int mid = left + (right - left >> 1);
            if (!canfinish(piles, mid, h)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private boolean canfinish(int[] piles, int speed, int h) {
        int time = 0;
        for (int p: piles) {
            if (p % speed == 0) {
                time += p/speed;
            } else {
                time += p/speed + 1;
            }
            if (time > h) return false;
        }
        return true;
    }
}
