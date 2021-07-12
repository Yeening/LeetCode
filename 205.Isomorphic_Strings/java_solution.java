class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] map = new int[128], mapped = new int[128];
        Arrays.fill(map, -1);
        Arrays.fill(mapped, -1);
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i), c2 = t.charAt(i);
            if (map[c1] == -1) {
                map[c1] = c2;
            } else if (map[c1] != c2) {
                return false;
            }
            if (mapped[c2] == -1) {
                mapped[c2] = c1;
            } else if (mapped[c2] != c1) {
                return false;
            }
        }
        return true;
    }
}
