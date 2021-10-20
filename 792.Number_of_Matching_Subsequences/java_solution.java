// solution 1: checking match for every word, 99ms
// time: O(N*s.length()), N = words.length, space: O(N)
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

// solution 2: keep a map of startChar:word, 37ms
// time: O(N * s.length()), space: O(N)
class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        // int[]{wordIndex, startPos}
        Queue<int[]>[] headQueues = new Queue[26]; // {a: [0,0], [2,0], [3,0], b:[1,0]}
        int match = 0;
        for (int i = 0; i < 26; i++) {
            headQueues[i] = new ArrayDeque<>();
        }
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.isEmpty()) {
                match++;
            } else {
                char start = word.charAt(0);
                headQueues[start - 'a'].offer(new int[]{i, 0});
            }
        }
        
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            Queue<int[]> curQueue = headQueues[cur - 'a'];
            int size = curQueue.size();
            for (int j = 0; j < size; j++) {
                int[] wordRep = curQueue.poll();
                String word = words[wordRep[0]];
                int start = wordRep[1];
                if (start == word.length() - 1) {
                    match++;
                } else {
                    wordRep[1]++;
                    headQueues[word.charAt(start + 1) - 'a'].offer(wordRep);
                }
            }
        }
        
        return match;
    }
}
