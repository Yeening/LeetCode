class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null||nums.length==0) return new int[0];
        Deque<Integer> deque = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        for(int i = 0; i < nums.length; i++){
            // poll the passed item
            if(!deque.isEmpty()&&deque.peek()<i-k+1) deque.poll();
            while(!deque.isEmpty()&&nums[deque.peekLast()]<nums[i]) deque.pollLast();
            deque.addLast(i);
            if(i > k-2) res[index++] = nums[deque.peek()];
        }
        return res;
    }
}
