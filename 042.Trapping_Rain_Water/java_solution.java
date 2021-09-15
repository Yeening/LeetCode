// https://labuladong.gitbook.io/algo/mu-lu-ye-4/jie-yu-shui
class Solution {
    public int trap(int[] height) {
        int leftMax = 0, rightMax = 0;
        int i = 0, j = height.length-1;
        int res = 0;
        while(i < j){
            leftMax = Math.max(height[i], leftMax);
            rightMax = Math.max(height[j], rightMax);
            if(leftMax < rightMax){
                res += leftMax - height[i];
                i++;
            }
            else{
                res += rightMax - height[j];
                j--;
            }
        }
        return res;
    }
}
