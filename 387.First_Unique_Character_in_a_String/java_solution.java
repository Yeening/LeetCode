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

// O(N)
class Solution {
    public int firstUniqChar(String s) {
        // > -1: unique occur index; -1: not yet occur; -2: more than once
        int[] charOccurs = new int[26];
        int duplicate = 0; // optional, optimize for long sequence
        Arrays.fill(charOccurs, -1);
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (charOccurs[cur - 'a'] == -2) {
                continue;
            } else if (charOccurs[cur - 'a'] > -1) {
                charOccurs[cur - 'a'] = -2;
                duplicate++;
                if (duplicate == 26) {return -1;}
            } else {
                charOccurs[cur - 'a'] = i;
            }
        }
        int first = s.length();
        for (int occur: charOccurs) {
            if (occur > -1) {
                first = Math.min(first, occur);
            }
        }
        return first == s.length()? -1: first;
    }
}
