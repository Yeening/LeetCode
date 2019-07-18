class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        for(int i=0,j=0; j<s.length(); j++){
            if(map.containsKey(s.charAt(j))){
                i = Math.max(i, (map.get(s.charAt(j))+1));
            }
            maxLength = Math.max(maxLength, j - i + 1);
            map.put(s.charAt(j),j);
        }
        return maxLength;
    }
}
