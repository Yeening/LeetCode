class Solution {
    /*
    3[a2[bc]]
    3,2
    [,a,cbcb
    
    2
    3[a]
    */
    public String decodeString(String s) {
        if (s.isEmpty()) return s;
        Deque<Integer> kStack = new ArrayDeque<>();// [1,3]
        kStack.push(1);
        Deque<String> sStack = new ArrayDeque<>(); //["[",]
        sStack.push("[");
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (Character.isDigit(cur)) {
                int val = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    val = val * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--;
                kStack.push(val);
            } else if (cur == ']'){
                decode(sStack, kStack);
            } else {
                sStack.push(String.valueOf(cur));
            }
        }
        decode(sStack, kStack);
        StringBuilder sb = new StringBuilder(sStack.pop());
        sb.reverse();
        return sb.toString();
    }
    
    private void decode(Deque<String> sStack, Deque<Integer> kStack) {
        StringBuilder sb = new StringBuilder(); //"a"
        while (!sStack.isEmpty()) {
            String cur = sStack.pop(); //"a"
            if (cur.equals("[")) {break;}
            sb.append(cur);
        }
        int k = kStack.pop(); //3
        String string = sb.toString(); //"a"
        for (int i = 0; i < k - 1; i++) {
            sb.append(string);
        }
        sStack.push(sb.toString());
    }
}
