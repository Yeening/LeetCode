class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String s: tokens){
            if(Character.isDigit(s.charAt(0))||(s.charAt(0)=='-' && s.length() > 1)){
                stack.push(Integer.valueOf(s));
            } else{
                int a = stack.pop();
                int b = stack.pop();
                if(s.equals("+")){
                    stack.push(a+b);
                } else if(s.equals("-")){
                    stack.push(b-a);
                } else if(s.equals("*")){
                    stack.push(b*a);
                } else{
                    stack.push(b/a);
                }
            }
        }
        return stack.pop();
    }
}
