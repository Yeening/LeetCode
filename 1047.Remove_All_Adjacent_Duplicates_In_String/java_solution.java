class Solution {
    /*
    charArr:[c,a,b]
                 j
             abbaca
                    i
    */
    public String removeDuplicates(String s) {
        char[] charArr = s.toCharArray();
        int stackIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            charArr[stackIndex] = cur;
            if (stackIndex != 0 && charArr[stackIndex - 1] == cur) {
                stackIndex -= 2;
            }
            stackIndex++;
        }
        return new String(charArr, 0, stackIndex);
    }
}
