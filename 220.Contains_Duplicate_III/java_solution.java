class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        Map<Long, Long> buckets = new HashMap<>();
        Map<Integer, Long> iToB = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > indexDiff) {
                int indexToRemove = i - indexDiff - 1;
                long bucketToRemove = iToB.remove(indexToRemove);
                buckets.remove(bucketToRemove);
            }
            long adjusted = (long) nums[i] - Integer.MIN_VALUE;
            long bucket;
            if (valueDiff == 0) {
                bucket = adjusted;
            } else {
                bucket = adjusted / valueDiff;
            }
            if (buckets.containsKey(bucket) || 
                buckets.containsKey(bucket - 1) && buckets.get(bucket - 1) >= adjusted - valueDiff ||
                buckets.containsKey(bucket + 1) && buckets.get(bucket + 1) <= adjusted + valueDiff
                ) {
                    return true;
                }
            buckets.put(bucket, adjusted);
            iToB.put(i, bucket);
        }
        return false;
    }
}
