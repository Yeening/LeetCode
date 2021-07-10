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

class Solution {
    public String minWindow(String s, String t) {
        int start = -1, len = s.length() + 1;
        int left = 0, right = 0, valid = 0, needCount = 0;
        int[] need = new int[200], window = new int[200];
        for (char c: t.toCharArray()) {
            if (need[c] == 0) needCount++;
            need[c]++;
        }
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need[c] > 0) {
                window[c]++;
                if (window[c] == need[c]) {
                    valid++;
                }
            }

            while (valid == needCount) {
                if (right - left < len) {
                    len = right - left;
                    start = left;
                }
                c = s.charAt(left);
                left++;
                if (need[c] > 0) {
                    if (window[c] == need[c]) {
                        valid--;
                    }
                    window[c]--;
                }
            }
        }

        if (start == -1) return "";
        return s.substring(start, start + len);
    }
}
