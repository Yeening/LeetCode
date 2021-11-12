class Solution {
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
