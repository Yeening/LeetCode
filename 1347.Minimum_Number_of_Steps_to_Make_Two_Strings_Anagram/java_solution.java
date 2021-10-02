// time: O(N), space: O(number of distinct characters)
class Solution {
    // {l:1, e:3, t:1, c: 1, o: 1, d: 1, p: -1}
    public int minSteps(String s, String t) {
        int[] charCount = new int[26];
        int operations = 0;
        for (char c: s.toCharArray()) {
            charCount[c - 'a']++;
        }
        for (char c: t.toCharArray()) {
            charCount[c - 'a']--;
        }
        for (int count: charCount) {
            if (count > 0) {operations += count;}
        }
        return operations;
    }
}
