class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        Set<String> dict = new HashSet<>(wordDict);
        for(int i = 1; i < s.length()+1;i++){
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
