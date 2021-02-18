// Solution 1: using StringBuilder
class Solution {
    public String reverseWords(String s) {
        StringBuilder cur = new StringBuilder();
        LinkedList<String> stack = new LinkedList<>();
        for(char c: s.toCharArray()){
            if(c != ' '){
                cur.append(c);
            } else if(cur.length() > 0){
                stack.addFirst(cur.toString());
                cur = new StringBuilder();
            }
        }
        if(cur.length() > 0){
            stack.addFirst(cur.toString());
            cur = new StringBuilder();
        }
        while(!stack.isEmpty()){
            cur.append(stack.pollFirst());
            cur.append(' ');
        }
        if(cur.length() > 0) {
            cur.deleteCharAt(cur.length() - 1);
        }
        return cur.toString();
    }
}

// Solution 2: without StringBuilder
class Solution {
    public String reverseWords(String s) {
        LinkedList<String> stack = new LinkedList<>();
        int wordStart = 0;
        s += " ";
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c != ' ' && s.charAt(wordStart) != ' '){
                continue;
            } else if(c == ' ' && s.charAt(wordStart) != ' '){
                stack.addFirst(s.substring(wordStart, i));
            }
            wordStart = i;
        }
        String res = "";
        while(!stack.isEmpty()){
            res += stack.pollFirst();
            res += " ";
        }
        if(res.length() > 0) {
            res = res.substring(0, res.length() - 1);
        }
        return res;
    }
}
