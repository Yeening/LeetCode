// https://labuladong.gitbook.io/algo/mu-lu-ye-1/mu-lu-ye-2/dan-tiao-zhan

// Solution 1: repeating the array
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> s = new Stack<>();
        for (int i = 2 * n - 1; i >= 0; i--) {
            int index = i % n;
            while (!s.isEmpty() && s.peek() <= nums[index]) {
                s.pop();
            }
            res[index] = s.isEmpty()? -1: s.peek();
            s.push(nums[index]);
        }
        return res;
    }
}

// Solution 2: breaking the circle by the greatest element
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int maxI = 0, n = nums.length;
        int[] res = new int[n];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] >= nums[maxI]) {
                maxI = i;
            }
        }
        s.push(nums[maxI]);
        res[maxI] = -1;
        for (int i = (maxI - 1 + n) % n; i != maxI; i = (i - 1 + n) % n) {
            while (!s.isEmpty() && s.peek() <= nums[i]) {
                s.pop();
            }
            res[i] = s.isEmpty()? -1: s.peek();
            s.push(nums[i]);
        }
        return res;
    }
}
