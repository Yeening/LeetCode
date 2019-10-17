class Solution {
    public String addBinary(String a, String b) {
        if(a.length()<b.length()) return addBinary(b,a);
        int i = a.length()-1;
        int remain = 0;
        StringBuilder sb = new StringBuilder();
        for(int j = b.length()-1; j >=0 ; j--){
            int dig1 = a.charAt(i) - '0', dig2 = b.charAt(j) - '0';
            sb.append(dig1^dig2^remain);
            remain = (dig1 + dig2 + remain)/2;
            i--;
        }
        # Deal with the extra digs
        while(i>=0){
            int dig1 = a.charAt(i) - '0';
            sb.append(dig1^remain);
            remain = (remain + dig1)/2;
            i--;
        }
        if(remain>0){
            sb.append(1);
        }
        return sb.reverse().toString();
    }
}
