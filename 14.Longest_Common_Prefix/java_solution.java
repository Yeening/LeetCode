class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0) return "";
        if(strs.length==1) return strs[0];
        Arrays.sort(strs);
        String head = strs[0], tail = strs[strs.length-1];
        while(tail.indexOf(head)!=0) head = head.substring(0, head.length()-1);
        return head;
    }
}
