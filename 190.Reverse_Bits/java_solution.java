public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for(int i = 0; i < 32; i++){ // Need to do 32 times
            res <<= 1;  // Caution the order
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }
}


public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int cur = n & 1;
            res |= (cur << (32 - i - 1));
            n = n >> 1;
        }
        return res;
    }
}
