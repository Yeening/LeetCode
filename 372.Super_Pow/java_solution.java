// https://labuladong.gitbook.io/algo/mu-lu-ye-3/mu-lu-ye-2/superpower
class Solution {
    int base = 1337;
    public int superPow(int a, int[] b) {
        return myPow(a, b, b.length - 1);
    }

    private int myPow(int a, int[] b, int bEnd) {
        if (bEnd == 0) return myPow(a, b[0]);
        int lastDig = b[bEnd];
        int first = myPow(a, lastDig);
        int second = myPow(myPow(a, b, bEnd - 1), 10);
        return (first * second) % base;
    }
    
    private int myPow(int a, int b) {
        int pow = 1;
        a = a % base;
        for (int i = 0; i < b; i++) {
            pow = (a * pow) % base;
        }
        return pow;
    }
}
