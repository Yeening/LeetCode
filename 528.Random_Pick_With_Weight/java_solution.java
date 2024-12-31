class Solution {
    private Random mRandom;
    private int[] maxWeight;
    public Solution(int[] w) {
        if (w == null || w.length == 0) return;
        mRandom = new Random();
        maxWeight = w;
        for (int i = 1; i < w.length; i++) {
            maxWeight[i] = maxWeight[i-1] + w[i];
        }
    }
    
    public int pickIndex() {
        if (mRandom == null) return -1;
        int weightedIndex = mRandom.nextInt(maxWeight[maxWeight.length - 1]);
        return search(0, maxWeight.length, weightedIndex);
    }

    // search for an index in [start, end) that 
    // maxWeight[index - 1] <= weight < maxWeight[index]
    // if weight < maxWeight[0], return 0
    private int search(int start, int end, int weight) {
        while (start < end) {
            int mid = start + ((end - start) >> 1);
            if (weight < maxWeight[mid]) {
                if (mid == 0 || weight >= maxWeight[mid - 1]) {
                    // found
                    return mid;
                }
                end = mid;
                continue;
            }
            start = mid + 1;
        }
        return -1;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
