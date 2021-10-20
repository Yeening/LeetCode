class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        Map<String, Integer> match = new HashMap<>();
        int numMatching = 0;
        for (String word: words) {
            Integer matchCount = match.get(word);
            if (matchCount != null) {
                numMatching += matchCount;
            } else {
                if (canMatch(s, word)) {
                    match.put(word, 1);
                    numMatching += 1;
                } else {
                    match.put(word, 0);
                }
            }
        }
        return numMatching;
    }
    
    private boolean canMatch(String s, String word) {
        if (s.length() < word.length()) {return false;}
        int sIndex = 0, wIndex = 0;
        while (sIndex < s.length() && wIndex < word.length()) {
            if (s.charAt(sIndex) == word.charAt(wIndex)) {
                sIndex++;
                wIndex++;
            } else {
                sIndex++;
            }
        }
        return wIndex == word.length();
    }
}
