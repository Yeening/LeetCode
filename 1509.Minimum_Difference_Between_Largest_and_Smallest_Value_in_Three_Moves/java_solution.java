// Time: O(N + log(K+1))
// Space: O(K)

class Solution {
    // maxHeap: {10, 5, 1, 0}
    // minHeap: {1, 5, 10, 14}
    // maxVals: [14, 10, 5, 1]
    // minVals: [0, 1, 5, 10]
    
    public int minDifference(int[] nums) {
        if (nums.length <= 4) return 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b,a)), minHeap = new PriorityQueue<>();
        for (int i: nums) {
            maxHeap.add(i);
            if (maxHeap.size() > 4) {
                maxHeap.poll();
            }
            minHeap.add(i);
            if (minHeap.size() > 4) {
                minHeap.poll();
            }
        }
        int[] maxValues = new int[4], minValues = new int[4];
        for (int i = 3; i >= 0; i--) {
            maxValues[i] = minHeap.poll();
            minValues[i] = maxHeap.poll();
        }
        int minDiff = maxValues[0] - minValues[0];
        for (int i = 0; i < 4; i++) {
            minDiff = Math.min(minDiff, 
                               maxValues[i] - minValues[3-i]);
        }
        return minDiff;
    }
}
