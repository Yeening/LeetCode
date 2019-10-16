class Solution {
    public int[] plusOne(int[] digits) {
        int com_digit = digits.length-1;
        digits[com_digit] += 1;
        while(com_digit>0&&digits[com_digit]==10){
            digits[com_digit] = 0;
            digits[--com_digit] += 1;
        }
        if(digits[0]==10){
            int[] res = new int[digits.length+1];
            res[0] = 1;
            res[1] = 0;
            for(int i = 1; i < digits.length; i++){
                res[i+1] = digits[i];
            }
            return res;
        }
        return digits;
    }
}
