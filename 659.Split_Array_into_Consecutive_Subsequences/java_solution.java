// Solution 1 O(n) time, O(N) space
class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>(), need = new HashMap<>();
        for (int i: nums) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }
        for (int i: nums) {
            // already used up
            if (freq.get(i) == 0) continue;
            // can extend an existing sequence
            if (need.getOrDefault(i, 0) > 0) {
                // put it to an existing sequence
                need.put(i, need.get(i) - 1);
                freq.put(i, freq.get(i) - 1);
                need.put(i + 1, need.getOrDefault(i + 1, 0) + 1);
            }
            // can set up an new sequence
            else if (freq.getOrDefault(i+1, 0) > 0 &&
                    freq.getOrDefault(i+2, 0) > 0) {
                freq.put(i, freq.get(i) - 1);
                freq.put(i + 1, freq.get(i + 1) - 1);
                freq.put(i + 2, freq.get(i + 2) - 1);
                need.put(i + 3, need.getOrDefault(i+3, 0) + 1);
            } else {
                return false;
            }
        }
        return true;
    }
}
