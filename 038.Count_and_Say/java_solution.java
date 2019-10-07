class Solution {
    public String countAndSay(int n) {
        if(n==1) return "1";
        String s = countAndSay(n-1);
        //StringBuilder is much faster than string + char and string + String.valueOf(int)
        StringBuilder sb = new StringBuilder();
        char pre = s.charAt(0);
        int count = 1;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i)!=pre){
                sb.append(count);
                sb.append(pre);
                count = 1;
                pre = s.charAt(i);
            }
            else count++;
        }
        sb.append(count);
        sb.append(pre);
        return sb.toString();
    }
}
