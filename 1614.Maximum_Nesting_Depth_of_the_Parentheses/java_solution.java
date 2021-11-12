class Solution {
    public int maxDepth(String s) {
        int left = 0, maxDepth = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                left++;
                maxDepth = Math.max(left, maxDepth);
            } else if (c == ')') {
                left--;
            }
        }
        return maxDepth;
    }
}
