//Solution1, simpilified reverse Polish, 36%
class Solution {
    Stack<Integer> numStack = new Stack<>();
    Stack<Character> symbolStack = new Stack<>();    
    public int calculate(String s) {

        for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            if(Character.isDigit(cur)){
                int curValue = (int) (cur - '0');
                while(i + 1 < s.length() && Character.isDigit(s.charAt(i+1))){
                    cur = s.charAt(++i);
                    curValue = curValue * 10 + (int) (cur - '0');
                }
                numStack.push(curValue);
            }
            else if(cur == '+' || cur =='-'){
                while(!symbolStack.isEmpty()){
                    popSymbol();
                }
                symbolStack.push(cur);
            }
            else if(cur == '*' || cur =='/'){
                while(!symbolStack.isEmpty()&&   (symbolStack.peek()=='*'||symbolStack.peek()=='/'))
                    popSymbol();
                symbolStack.push(cur);
            }
        }
        while(!symbolStack.isEmpty()) popSymbol();
        return numStack.peek();
    }
    
    private void popSymbol(){
        int tmp1 = numStack.pop();
        int tmp2 = numStack.pop();
        char operator = symbolStack.pop();
        if(operator == '+') numStack.push(tmp2 + tmp1);
        else if(operator == '-') numStack.push(tmp2 - tmp1);
        else if(operator == '*') numStack.push(tmp2 * tmp1);
        else if(operator == '/') numStack.push(tmp2 / tmp1);
    }
}

//Solution2, iterative, 72%
class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char lastOp = '+';
        s += '+';
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == ' ') continue;
            if(Character.isDigit(c)){
                num = num * 10 + (s.charAt(i) - '0');
                continue;
            }
            if(lastOp == '+'){
                stack.push(num);
            }
            else if(lastOp=='-'){
                stack.push(-num);
            }
            else if(lastOp=='*'){
                stack.push(stack.pop()*num);
            }
            else if(lastOp=='/'){
                stack.push(stack.pop()/num);
            }
            num = 0;
            lastOp = c;
        }
        int res = 0;
        while(!stack.isEmpty()) res += stack.pop();
        return res;
    }
}
