class Solution {
public:
    string minWindow(string s, string t) {
        if(s.size()==0||s.size()<t.size()) 
            return "";
        vector<int> map(128,0);
        for(int i = 0; i < t.size(); i++){
            map[t[i]] ++;
        }
        int end = 0, start = 0, count = t.size();
        int min_start = 0, min_length = s.size()+1;
        while(end<s.size()){
            if(map[s[end]]>0) count--;
            //if not exist in t, the value in map will be negative
            map[s[end]]--;
            end++;
            while(count==0){
                if(end-start < min_length){
                    min_start = start;
                    min_length = end - start;
                }
                map[s[start]]++;
                if(map[s[start]] > 0) count++;
                start++;
            }
        }
        if(min_length==s.size()+1) return "";
        return s.substr(min_start, min_length);
    }
};
