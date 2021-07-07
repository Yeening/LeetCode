class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0, right = 0;
        for (int w: weights) {
            left = Math.max(left, w);
            right += w;
        }

        while (left <= right) {
            int mid = left + (right - left >> 1);
            if (!canFinish(weights, mid, days)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    private boolean canFinish(int[] weights, int capacity, int days) {
        int time = 1, remaining = capacity;
        for (int w: weights) {
            if (remaining >= w) {
                remaining -= w;
            } else {
                time++;
                remaining = capacity - w;
                if (time > days) return false;
            }
        }
        return true;
    }
}
