class Solution {
    // time: O(blacklist.length)
    // space: O(blacklist.length)
    // map each black-listed element in range [0, whiteRange] to a 
    // white-listed element out of the range
    int whiteRange; // 4
    Map<Integer, Integer> mapping; // {2:4, }
    Random random;
    public Solution(int n, int[] blacklist) {
        whiteRange = n - blacklist.length; // 4 
        Set<Integer> set = new HashSet<>(); // {}
        for (int i: blacklist) set.add(i); // {2, 3, 5}
        mapping = new HashMap<>();
        int r = whiteRange; // l: 3, r: 5
        for (int l: blacklist) {
            if (l < whiteRange) {
                while (set.contains(r)) {
                    r++;
                }
                mapping.put(l, r++);
            }
        }
        random = new Random();
    }
    
    public int pick() {
        int rand = random.nextInt(whiteRange);
        if (mapping.containsKey(rand)) return mapping.get(rand);
        return rand;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */
