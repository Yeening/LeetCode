class Solution {
    public int maxArea(int[] height) {
        if(height==null||height.length<2) return 0;
        int l = 0, r = height.length-1;
        int maxA = 0;
        while(r > l){
            maxA = Math.max(maxA, (r - l) * Math.min(height[r], height[l]));
            if(height[l] < height[r]){
                l++;
            }
            else{
                r--;
            }
        }
        return maxA;
    }
}
