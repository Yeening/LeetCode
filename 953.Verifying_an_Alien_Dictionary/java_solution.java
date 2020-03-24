class Solution {
    int[] dict = new int[26];
    
    public boolean isAlienSorted(String[] words, String order) {
        if(words==null||words.length==0) return false;
        for(int i = 0; i < order.length(); i++){
            dict[order.charAt(i)-'a'] = i;
        }
        for(int i = 0; i < words.length - 1; i++){
            if(compare(words[i], words[i+1]) > 0) return false;
        }
        return true;
    }
    
    private int compare(String s1, String s2){
        int min_length = Math.min(s1.length(), s2.length());
        for(int i = 0; i < min_length; i++){
            if(dict[s1.charAt(i)-'a'] < dict[s2.charAt(i)-'a'])
                return -1;
            if(dict[s1.charAt(i)-'a'] > dict[s2.charAt(i)-'a'])
                return 1;
        }
        return s1.length() - s2.length();
    }
}
