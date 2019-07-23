//My solution, uses a linked list as stack, linkedlist supports push,pop and peek
//beats 98% solutions
class Solution {
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            switch(c){
                case '(':
                    stack.push(')');
                    break;
                case '[':
                    stack.push(']');
                    break;
                case '{':
                    stack.push('}');
                    break;
                default:
                    if(stack.isEmpty()||stack.pop()!=c) return false;
                    break;
            }
        }
        return stack.isEmpty();
    }
}
