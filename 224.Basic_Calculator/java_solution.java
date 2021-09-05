//Solution 1: 15%, Reverse Polish notation
class Solution {
    public int calculate(String s) {
        List<String> list = toReversePolish(s);
        int res = calculateRPolish(list);
        return res;
    }
    
    private List<String> toReversePolish(String s){
        Stack<Character> symbolStack = new Stack<>();
        Deque<Integer> deque = new LinkedList<>();
        List<String> list = new ArrayList<>();
        int value = 0;
        for(char c: s.toCharArray()){
            if(c == ' ') 
                continue;
            else if(c == '(') 
                symbolStack.push(c);
            else if(c == ')'){
                if(!deque.isEmpty()){
                    value = 0;
                    while(!deque.isEmpty()){
                        value *= 10;
                        value += deque.pollFirst();
                    }
                    list.add(String.valueOf(value));
                }
                while(!symbolStack.isEmpty()&&symbolStack.peek()!='('){
                    list.add(Character.toString(symbolStack.pop()));
                }
                symbolStack.pop(); //there must be a '(' before ')'
            }
            else if(c >= '0' && c <= '9'){
                deque.addLast(c - '0');
            }
            else if(c == '+' || c == '-'){
                if(!deque.isEmpty()){
                    value = 0;
                    while(!deque.isEmpty()){
                        value *= 10;
                        value += deque.pollFirst();
                    }
                    list.add(String.valueOf(value));
                }
                while(!symbolStack.isEmpty()&&symbolStack.peek()!='('){
                    list.add(Character.toString(symbolStack.pop()));
                }
                symbolStack.push(c);
            }
        }
        
        if(!deque.isEmpty()){
            value = 0;
            while(!deque.isEmpty()){
                value *= 10;
                value += deque.pollFirst();
            }
            list.add(String.valueOf(value));
        }
        
        while(!symbolStack.isEmpty()){
            list.add(Character.toString(symbolStack.pop()));
        }
        return list;
    }
    
    private int calculateRPolish(List<String> list){
        Stack<Integer> stack = new Stack<>();
        for(String s: list){
            if(s.charAt(0) >= '0' && s.charAt(0) <= '9')
                stack.push(Integer.valueOf(s));
            else{
                int ele1 = stack.pop();
                int ele2 = stack.pop();
                if(s.equals("+")){
                    stack.push(ele2 + ele1);
                }
                else if(s.equals("-")){
                    stack.push(ele2 - ele1);
                }
            }
        }
        return stack.peek();
    }
}

//Solution 2: Iterative, 98%
class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int curValue = 0;
        int sign = 1;
        int sum = 0;
        for(char c: s.toCharArray()){
            if(c>='0' && c<='9'){
                curValue = curValue * 10 + (c - '0');
            }
            else if(c == '+'){
                sum += curValue * sign;
                sign = 1;
                curValue = 0;
            }
            else if(c == '-'){
                sum += curValue * sign;
                sign = -1;
                curValue = 0;
            }
            else if(c == '('){
                stack.push(sum);
                stack.push(sign);
                sum = 0;
                sign = 1;
            }
            else if(c == ')'){
                sum += curValue * sign;
                curValue = 0;
                int tmpSign = stack.pop();
                int tmpSum = stack.pop();
                sum = sum * tmpSign + tmpSum;
            }
        }
        sum += curValue * sign;
        return sum;
    }
}


// Solution 3:

class Solution {
    public int calculate(String s) {
        Stack<String> stack = new Stack<>();
        Integer temp = null;
        s = "(" + s + ")";
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (Character.isDigit(cur)) {
                temp = temp == null? 0: temp;
                temp = temp * 10 + (cur - '0');
            } else {
                if (temp != null) {
                    stack.push(String.valueOf(temp));
                    temp = null;
                }
            }

            if (cur == '-' || cur == '(') {
                stack.push(String.valueOf(cur));
            } else if (cur == ')') {
                stack.push(String.valueOf(getValueInsidePar(stack)));
            }
        }
        return Integer.parseInt(stack.pop());
    }
    
    private int getValueInsidePar(Stack<String> stack) {
        int val = 0, lastVal = 0;
        while (!stack.isEmpty()) {
            String temp = stack.pop();
            if (temp.equals("(")) {
                return val + lastVal;
            } else if (temp.equals("-")) {
                val += -lastVal;
                lastVal = 0;
            } else {
                // temp is number
                val += lastVal;
                lastVal = Integer.valueOf(temp);
            }
        }
        return val;
    }
}
