//Two pointer, beats 68%
class Solution {
    public int firstUniqChar(String s) {
        if(s==null || s.length()==0) return -1;
        int N = s.length();
        int[] count = new int[256];
        int slow = 0, fast = 0;
        for(; fast < N; fast++){
            count[s.charAt(fast)]++;
            while(slow < N && count[s.charAt(slow)] > 1){
                slow++;
            }
            if(slow >= N){
                return -1;
            }
        }
        return slow;
    }
}
