//my solution
class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        vector<vector<char>> dic(strs.size());
        vector<string> m_strs = strs;
        unordered_map<string,vector<int>> hash;
        for(int i = 0; i < m_strs.size(); i++){
            sort(m_strs[i].begin(),m_strs[i].end());
            hash[m_strs[i]].push_back(i);
            
        }
        vector<vector<string>> res;
        for(auto it = hash.begin();it!=hash.end();it++){
            vector<string> group;
            for(int i = 0; i < it->second.size(); i++){
                group.push_back(strs[(it->second)[i]]);
            }
            res.push_back(group);
        }
        
        return res;
    }
};
