// 424. Longest Repeating Character Replacement

class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0, r = 0, maxFreq = 0, maxLength = 0;
        int[] freq = new int[128];
        char mainC = s.charAt(0);
        while (r < s.length()) {
            char c = s.charAt(r++);
            freq[c]++;
            if (freq[c] > maxFreq) {
                maxFreq = freq[c];
                mainC = c;
            }

            while (r - l - maxFreq > k) {
                char remove = s.charAt(l++);
                freq[remove]--;
                if (mainC == remove) {
                    mainC = findMainC(freq);
                    maxFreq = freq[mainC];
                }
            }

            maxLength = Math.max(maxLength, r - l);
        }

        return maxLength;
    }

    private char findMainC(int[] freq) {
        char mainC = 'a';
        for (char c = 'A'; c <= 'Z'; c++) {
            if (freq[c] > freq[mainC]) mainC = c;
        }
        return mainC;
    }
}
