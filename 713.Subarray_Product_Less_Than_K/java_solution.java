class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1||nums==null||nums.length==0) return 0;
        int i = 0,  product = 1;
        int count = 0;
        for(int j = 0; j < nums.length; j++){
            product *= nums[j];
            while(product>=k){
                product /= nums[i++];
            }
            count += (j-i+1);
        }
        return count;
    }
}
