class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>(), res = new HashSet<>();
        for (int i = 10; i <= s.length(); i++) {
            String cur = s.substring(i - 10, i);
            if (!seen.add(cur)) {
                // seen, Set.add() returns false when already contains
                res.add(cur);
            }
        }
        return new ArrayList<>(res);
    }
}
