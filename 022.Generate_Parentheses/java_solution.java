class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        int left = n, right = n;
        backTracking(0, 0, n, "", res);
        return res;
    }
    private void backTracking(int open, int closed, int n, String temp
                              , List<String> res){
        if(temp.length()==n*2){
            res.add(temp);
            return;
        }
        //if there is '(' left, try to put it
        if(open<n){
            backTracking(open+1, closed, n, temp+'(', res);
        }
        //if there is unclosed, try to put right parenthesis
        if(closed<open){
            backTracking(open, closed+1,n, temp+')', res);
        }
    }
}
