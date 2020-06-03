//https://leetcode.com/explore/interview/card/amazon/76/array-and-strings/2961/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[300];
        char[] ca = s.toCharArray();
        int max = 0, cur = 0, l = 0;
        for(int r = 0; r < ca.length; r++){
            while(map[ca[r]]!=0){
                map[ca[l]]--;
                l++;
            }
            map[ca[r]]++;
            max = Math.max(r-l+1, max);
        }
        return max;
    }
}
