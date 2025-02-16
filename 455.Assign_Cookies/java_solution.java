class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int content = 0, index = s.length - 1;
        for (int i = g.length - 1; i >= 0 && index >= 0; i--) {
            if (s[index] >= g[i]) {
                content++;
                index--;
            }
        }
        return content;
    }
}
