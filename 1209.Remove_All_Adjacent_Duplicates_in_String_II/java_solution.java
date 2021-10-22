// solution 1: using counting array
// time: O(N), space: O(N)
class Solution {
    /*
    deeed
       cI
        i
    count: [1,2,2,]
    ca:[d,d,e]
    */
    public String removeDuplicates(String s, int k) {
        char[] charArr = s.toCharArray();
        int[] count = new int[s.length()];
        int countIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (countIndex == 0 || charArr[countIndex - 1] != cur) {
                count[countIndex] = 1;
            } else {
                // countIndex > 0 && charArr[countIndex - 1] == cur
                count[countIndex] = count[countIndex - 1] + 1;
            }
            charArr[countIndex] = cur;
            if (count[countIndex] == k) {
                countIndex -= k;
            }
            countIndex++;
        }
        return new String(charArr, 0, countIndex);
    }
}

// solution 2: using stack
// time: O(N), space: O(N)
class Solution {
    /*
    deeed
       cI
        i
    count: [1,2,2,]
    ca:[d,d,e]
    */
    public String removeDuplicates(String s, int k) {
        char[] charArr = s.toCharArray();
        int[] count = new int[s.length()];
        int countIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (countIndex == 0 || charArr[countIndex - 1] != cur) {
                count[countIndex] = 1;
            } else {
                // countIndex > 0 && charArr[countIndex - 1] == cur
                count[countIndex] = count[countIndex - 1] + 1;
            }
            charArr[countIndex] = cur;
            if (count[countIndex] == k) {
                countIndex -= k;
            }
            countIndex++;
        }
        return new String(charArr, 0, countIndex);
    }
}
