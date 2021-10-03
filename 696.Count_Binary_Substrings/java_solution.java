// Solution 1: O(N) time, O(1) space
class Solution {
    public int countBinarySubstrings(String s) {
        int prevLen = 0, curLen = 1, count = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i-1)) {
                prevLen = curLen;
                curLen = 1;
            } else {
                curLen++;
            }
            if (prevLen >= curLen) {count++;}
        }
        return count;
    }
}

// Solution 2: O(N)time, O(1) space
class Solution {
    int count;
    /*
    "00110011"
          lr
    */ 
    public int countBinarySubstrings(String s) {
        count = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) != s.charAt(i+1)) {
                append(s, i, s.charAt(i), i+1, s.charAt(i+1));
            }
        }
        return count;
    }
    
    private void append(String s, int left, char leftC, 
                        int right, char rightC) {
        while (left >= 0 && right < s.length() && 
               s.charAt(left) == leftC && s.charAt(right) == rightC) {
            count++;
            left--;
            right++;
        }
    }
}
