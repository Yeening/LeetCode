class Solution {
    // Solution1 using a stack, performance not very good
    // public int longestValidParentheses(String s) {
    //     int maxLen = 0;
    //     LinkedList<Integer> stack = new LinkedList<>();
    //     for(int i = 0; i < s.length(); i++){
    //         char c = s.charAt(i);
    //         switch(c){
    //             case '(':
    //                 stack.addFirst(i);
    //                 break;
    //             case ')':
    //                 if(!stack.isEmpty()&&s.charAt(stack.getFirst())=='('){
    //                     stack.removeFirst();
    //                 }
    //                 else stack.addFirst(i);
    //         }
    //     }
    //     // stack.addFirst(s.length());
    //     stack.addLast(-1);
    //     int a = s.length(), b = 0;
    //     for(int i = 0; i < stack.size(); i++){
    //         b=stack.get(i);
    //         maxLen = Math.max(a - b - 1, maxLen);
    //         a=b;
    //     }
    //     return maxLen;
    // }
    
    //Solution2 DP, runtime 1ms, beat 100%
    public int longestValidParentheses(String s) {
        int maxLen = 0, n = s.length();
        //l[i] represents the length of the longest valid parentheses that ends at i
        int[] l = new int[n];
        for(int i = 1; i < n; i++){
            if(s.charAt(i)=='(') continue;
            if(s.charAt(i-1)=='('){
                if(i == 1) l[i] = 2;
                else l[i] = l[i-2] + 2;
                maxLen = Math.max(maxLen, l[i]);
            }
            else if(i-1-l[i-1]>-1&&s.charAt(i-1-l[i-1])=='('){
                if(i-1-l[i-1] == 0) l[i] = i+1;
                else l[i] = 2 + l[i-1] + l[i - l[i-1] - 2];
                maxLen = Math.max(maxLen, l[i]);
            }
        }
        return maxLen;
    }
}
