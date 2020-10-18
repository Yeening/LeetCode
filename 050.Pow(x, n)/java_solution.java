class Solution {
    public double myPow(double x, int n) {
        if(n == 0){
            return 1.0;
        }
        if(n < 0){
            if(n == Integer.MIN_VALUE);
            double tmp = x * myPow(x, -n-1);
            return 1.0 / tmp;
        }
        double tmp = myPow(x, n/2);
        if(n % 2 == 1){
            return x * tmp * tmp;
        } else{
            return tmp * tmp;
        }
    }
}
