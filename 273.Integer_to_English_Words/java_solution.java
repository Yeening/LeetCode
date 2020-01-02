class Solution {
    private final String[] lessThanTwenty = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] thousands = {"", "Thousand", "Million", "Billion"};
    
    public String numberToWords(int num) {
        if(num==0) return "Zero";
        
        String res = "";
        int thousandCount = 0;
        while(num>0){
            if(num%1000!=0)
                res = helper(num%1000)+ " " + thousands[thousandCount]+ " " + res;
            num /= 1000;
            thousandCount++;
        }
        return res.trim(); //.trim() removes the spaces in the begining and end
    }
    
    private String helper(int num){
        if(num<20) return lessThanTwenty[num];
        if(num<100) return (tens[num/10] + " " + lessThanTwenty[num%10]).trim();
        //100 - 999
        return (lessThanTwenty[num/100] + " Hundred " + helper(num%100)).trim();
    }
}
