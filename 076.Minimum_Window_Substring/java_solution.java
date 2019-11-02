class Solution {
    public String minWindow(String s, String t) {
        int[] map = new int[128];
        if(s.length()==0||s.length()<t.length()) return "";
        for(int i = 0; i < t.length(); i++){
            map[t.charAt(i)-'A'] ++;
        }
        int start = 0, end = 0, count = t.length();
        int min_end = s.length()+1, min_start = 0;
        while(end<s.length()){
            if(map[s.charAt(end)-'A'] > 0) count--;
            // if this char doesn't exist in t, the value in map will be negative
            map[s.charAt(end)-'A']--;
            end++;
            // when the current start-end window is valid, move start to get short
            while(count==0){
                if(end - start < min_end - min_start){
                    min_end = end;
                    min_start = start;
                }
                map[s.charAt(start)-'A']++;
                if(map[s.charAt(start)-'A']>0){
                    count++;
                }
                start++;
            }
        }
        if(min_end==s.length()+1) return "";
        return s.substring(min_start, min_end);
    }
}

// No need to sub 'A' with ASCII
class Solution {
    public String minWindow(String s, String t) {
        int[] map = new int[128];
        if(s.length()==0||s.length()<t.length()) return "";
        for(int i = 0; i < t.length(); i++){
            map[t.charAt(i)] ++;
        }
        int start = 0, end = 0, count = t.length();
        int min_end = s.length()+1, min_start = 0;
        while(end<s.length()){
            if(map[s.charAt(end)] > 0) count--;
            // if this char doesn't exist in t, the value in map will be negative
            map[s.charAt(end)]--;
            end++;
            // when the current start-end window is valid, move start to get short
            while(count==0){
                if(end - start < min_end - min_start){
                    min_end = end;
                    min_start = start;
                }
                map[s.charAt(start)]++;
                if(map[s.charAt(start)]>0){
                    count++;
                }
                start++;
            }
        }
        if(min_end==s.length()+1) return "";
        return s.substring(min_start, min_end);
    }
}
