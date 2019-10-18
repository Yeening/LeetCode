class Solution {
    public int mySqrt(int x) {
        if(x<2) return x;
        int lo = 1, hi = x-1;
        while(lo<=hi){
            int mid = (lo + hi)/2;
            if(mid > x/mid){
                hi = mid - 1;
                continue;
            }
            if((mid+1) <= x/(mid+1)){
                lo = mid + 1;
                continue;
            }
            return mid;
        }
        return -1;
    }
}
