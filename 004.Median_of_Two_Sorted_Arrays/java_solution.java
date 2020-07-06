class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int M = nums1.length, N = nums2.length;
        if(M > N){
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
            M = nums1.length; 
            N = nums2.length;
        }
        int iMin = 0, iMax = M, halfSize = (M + N + 1)/2;
        int leftMax = 0, rightMin = 0, i = (iMin + iMax)/2, j = halfSize - i;
        while(iMin <= iMax){
            i = (iMin + iMax)/2;
            j = halfSize - i;
            if(i > 0 && nums1[i-1] > nums2[j]){
                iMax = i - 1;
            }
            else if(i < M && nums1[i] < nums2[j-1]){
                iMin = i + 1;
            }
            else{
                if(i == 0) leftMax = nums2[j-1];
                else if(j == 0) leftMax = nums1[i-1];
                else leftMax = Math.max(nums1[i-1], nums2[j-1]);
                if((M + N) % 2 == 1) return leftMax;
                if(i == M) rightMin = nums2[j];
                else if(j == N) rightMin = nums1[i];
                else rightMin = Math.min(nums1[i], nums2[j]);
                return (double)(leftMax + rightMin) / 2.0;
            }
        }
        return -1;
    }
}
