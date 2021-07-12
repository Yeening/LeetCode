class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int left = 0, right = 0, flip = 0, len = 0;
        while (right < nums.length) {
            int c = nums[right];
            right++;
            if (c != 1) {
                flip++;
            }
            while (flip > 1) {
                c = nums[left];
                left++;
                if (c != 1) {
                    flip--;
                }
            }
            len = Math.max(len, right - left);
        }
        return len;
    }
}
