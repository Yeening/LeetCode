class Solution {
    // Solution1: Sorting 7ms
    // public boolean isAnagram(String s, String t) {
    //     if(s.length()!=t.length()) return false;
    //     char[] c1 = s.toCharArray();
    //     char[] c2 = t.toCharArray();
    //     Arrays.sort(c1);
    //     Arrays.sort(c2);
    //     return Arrays.equals(c1,c2);
    // }
    // Solution2: dic with three iterations: 5ms
    // public boolean isAnagram(String s, String t) {
    //     if(s.length()!=t.length()) return false;
    //     int[] dic = new int[26];
    //     for(int i = 0; i < s.length(); i++) dic[s.charAt(i)-'a'] ++;
    //     for(int i = 0; i < t.length(); i++){
    //         if(dic[t.charAt(i) - 'a']==0) return false;
    //         dic[t.charAt(i) - 'a']--;
    //     } 
    //     for(int num: dic) if(num!=0) return false;
    //     return true;
    // }
    //Solution3: dic with two iterations, 4ms
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        int[] dic = new int[26];
        for(int i = 0; i < t.length(); i++){
            dic[s.charAt(i)-'a'] ++;
            dic[t.charAt(i) - 'a']--;
        } 
        for(int num: dic) if(num!=0) return false;
        return true;
    }
}
