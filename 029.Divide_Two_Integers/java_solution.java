// Solution 1: adding powers of two
class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == 1<<31 && divisor == -1) return ~(1<<31);
        int negatives = 0;
        if(dividend > 0){
            negatives++;
            dividend = -dividend;
        }
        if(divisor > 0){
            negatives++;
            divisor = -divisor;
        }
        int res = 0;
        while(dividend <= divisor){
            int quotient = -1, cur = divisor, next = cur + cur;
            while(next < 0 && next >= dividend){
                quotient += quotient;
                cur = next;
                next = cur + cur;
            }
            dividend -= cur;
            res += quotient;
        }
        if(negatives != 1) res = -res;
        return res;
    }
}
