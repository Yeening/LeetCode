/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int lo = 1, hi = n, first = n;
        while(lo < hi){
            int mid = lo + (hi - lo) / 2;  //To avoid overflow
            if(isBadVersion(mid)){
                hi = mid - 1;
                first = mid;
            }
            else{
                lo = mid + 1;
            }
        }
        return first;
    }
}
