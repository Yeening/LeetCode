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
