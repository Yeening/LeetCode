// Solution1: with sorting, 1ms, 74%
// class Solution {
//     public String longestCommonPrefix(String[] strs) {
//         if(strs.length==0) return "";
//         if(strs.length==1) return strs[0];
//         Arrays.sort(strs);
//         String head = strs[0], tail = strs[strs.length-1];
//         while(tail.indexOf(head)!=0) head = head.substring(0, head.length()-1);
//         return head;
//     }
// }
// Solution2: without sorting, finding the max and min, 0ms, 100%
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0) return "";
        if(strs.length==1) return strs[0];
        String min = strs[0], max = strs[0];
        for(String str: strs){
            if(str.compareTo(max)>0) max = str;
            if(str.compareTo(min)<0) min = str;
        }
        while(max.indexOf(min)!=0) min = min.substring(0, min.length()-1);
        return min;
    }
}
