// Explain: https://leetcode.com/problems/sum-of-two-integers/discuss/132479/Simple-explanation-on-how-to-arrive-at-the-solution

class Solution {
    public int getSum(int a, int b) {
        if(reAbs(a) > reAbs(b)){
            int tmp = a;
            a = b;
            a = tmp;
        }
        long A = -reAbs(a);
        long B = -reAbs(b);
        boolean minus = (a<0) ^ (b<0);
        boolean neg = a < 0;
        while(B > 0){
            long nextA = A ^ B;
            if(minus){
                B = (~A & B) << 1;
            } else{
                B = (A & B) << 1;
            }
            A = nextA;
        }
        if(neg){
            return (int)-A;
        } else{
            return (int)A;
        }
    }
    
    private long reAbs(int n){
        if(n < 0) return n;
        return 0-n;
    }
}
