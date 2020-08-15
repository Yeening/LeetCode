class Solution {
    public int myAtoi(String str) {
        if(str==null) return 0;
        str = str.strip();
        if(str.length() == 0) return 0;
        char[] ca = str.toCharArray();
        int res = 0, symbol = 1, i = 0;
        if(ca[0] == '-'){
            symbol = -1;
            i++;
        }
        if(ca[0] == '+'){
            i++;
        }
        while(i < ca.length && Character.isDigit(ca[i])){
            int cur = ca[i++] - '0';
            if(res * 10 / 10 != res){
                return symbol > 0? Integer.MAX_VALUE: Integer.MIN_VALUE;
            }
            res = res * 10 + cur;
            if(res < 0) return symbol > 0? Integer.MAX_VALUE: Integer.MIN_VALUE;
        }
        return res * symbol;
    }
}
