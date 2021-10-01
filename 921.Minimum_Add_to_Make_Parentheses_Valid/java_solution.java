class Solution {
    // stack: 
    public int minAddToMakeValid(String s) {
        int stack = 0, extraRight = 0;
        for (char c: s.toCharArray()) {
            if (c == '(') {
                stack++;
            } else if (stack > 0) {
                stack--;
            } else {
                extraRight++;
            }
        }
        return stack + extraRight;
    }
}
