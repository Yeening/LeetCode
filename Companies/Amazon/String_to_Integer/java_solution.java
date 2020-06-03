//Question: https://leetcode.com/explore/interview/card/amazon/76/array-and-strings/2962/
class Solution {
    public int myAtoi(String str) {
        int value = 0, symbol = 1;
        boolean metSymbol = false, metDigit = false;
        for(char c: str.toCharArray()){
            if(c == ' '){
                if(!metDigit && !metSymbol) continue;
                else return value * symbol;
            }
            if(c == '+' && metSymbol==false){
                metSymbol = true;
            }
            else if(c == '-' && metSymbol==false){
                metSymbol = true;
                symbol = -1;
            }
            else if(Character.isDigit(c)){
                metDigit = true;  
                metSymbol = true;  //0-1 -> 0
                long tmp = (long)value * 10 + (c - '0');  //Whether the int out of range
                if(tmp!=value * 10 + (c - '0')){
                    if(symbol == 1) return Integer.MAX_VALUE;
                    else return Integer.MIN_VALUE;
                }
                value = (int)tmp;
            }
            else if(metDigit==true){
                return value * symbol;
            }
            else{
                return 0;
            }
        }
        return value * symbol;
    }
}
