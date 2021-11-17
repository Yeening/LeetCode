class Solution {
    // time: O(logN), space: O(logN)
    public int lastRemaining(int n) {
        return lastRemaining(n, 1, 1, true);
    }
    /*
    2,4,6,8,10
    LTR, odd: second
    LTR, even: second
    RTL, odd: second
    RTL, even: first
    */
    //5,2,2,false
    private int lastRemaining(int n, int start, int gap, boolean LTR) { 
        if (n == 1) {return start;}
        if (LTR || n % 2 == 1) {
            return lastRemaining(n/2, start + gap, gap << 1, !LTR);
        } else {
            return lastRemaining(n/2, start, gap << 1, !LTR);
        }
    }
}

// iterative
class Solution {
    public int lastRemaining(int n) {
        boolean LTR = true;
        int gap = 1, start = 1;
        while (n > 1) { // 2
            if (LTR || n % 2 == 1) {
                start += gap; // 2
            }
            gap = gap << 1; // 2
            n = n >> 1; // 2
            LTR = !LTR;
        }
        return start;
    }
    /*
    odd, LTR: start + gap
    odd, RTL: start + gap
    even, LTR: start + gap
    even, RTL:start
    */
}
