class Solution {
    public int hammingDistance(int x, int y) {
        int count = 0, XOR = x ^ y;
        while(XOR != 0){
            count += 1 & XOR;
            XOR >>>= 1;
        }
        return count;
    }
}
