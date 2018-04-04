class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        vector<int> index(128, -1);
        int max_length = 0, start = -1,p2 = 0;
        for(int i = 0 ; i < s.length(); i++){
            if(index[s[i]]>start){
                start = index[s[i]];
            }
            index[s[i]] = i;
            if((i - start)>max_length) max_length = i - start;
        }
        return max_length;
    }
};
