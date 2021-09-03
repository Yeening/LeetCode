class Solution {
    
    public int numDecodings(String s) {
        if (s == null || s.isEmpty() || s.charAt(0) == '0') return 0;
        int last = 1, lastLast = 1;
        for (int i = 1; i < s.length(); i++) {
            char curChar = s.charAt(i);
            int curCount = 0;
            if (curChar > '0' && curChar <= '9') {
                curCount += last;
            }
            if (isValidDoubleDigit(s.charAt(i-1), curChar)) {
                curCount += (lastLast);
            }
            lastLast = last;
            last = curCount;
        }
        return last;
    }
    
    private boolean isValidDoubleDigit(char fir, char sec) {
        if (fir == '1') {
            return sec >= '0' && sec <= '9';
        } else if (fir == '2') {
            return sec >= '0' && sec <='6';
        } else {
            return false;
        }
    }
    
}
