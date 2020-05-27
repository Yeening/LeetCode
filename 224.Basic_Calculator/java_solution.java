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
