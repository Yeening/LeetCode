class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        //dp[i] stands for a valid substring end with index i
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        Set<String> dict = new HashSet<>(wordDict);
        for(int i = 1; i < s.length()+1;i++){
            //from i-1 to 0 is much faster thamn from 0 to i-1
            for(int j = i-1; j >= 0; j--){
                if(dp[j]&&dict.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}

// With memo
class Solution {
    Boolean[] memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        memo = new Boolean[s.length() + 1];
        memo[0] = true;
        return canBreak(s, s.length(), wordSet);
    }

    private boolean canBreak(String s, int end, Set<String> wordSet){
        if(memo[end] != null) return memo[end];
        for(int i = end - 1; i >= 0; i--){
            if(wordSet.contains(s.substring(i, end)) && canBreak(s, i, wordSet)){
                memo[end] = true;
                return true;
            }
        }
        memo[end] = false;
        return false;
    }
}
