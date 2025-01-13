class Solution {
    public int minimumLength(String s) {
        int[] map = new int[128];
        for (char c: s.toCharArray()) {
            map[c]++;
        }

        int removed = 0;
        for (int c = 'a'; c <= 'z'; c++) {
            if (map[c] < 3) continue;
            removed += (map[c] - 1) / 2 * 2;
        }

        return s.length() - removed;
    }
}
