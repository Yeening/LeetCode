//Solution 1: add sum, 0ms
class Solution {
    public int missingNumber(int[] nums) {
        int N = nums.length;
        int sum = 0, target = (N + 1) * N / 2;
        for(int i: nums){
            sum += i;
        }
        return target - sum;
    }
}

//Solution 2: bit manipulation, 0ms
class Solution {
    public int missingNumber(int[] nums) {
        int tmp = 0, i = 0;
        for(i = 0; i < nums.length; i++){
            tmp = tmp ^ i ^ nums[i];
        }
        return tmp ^ i;
    }
}
