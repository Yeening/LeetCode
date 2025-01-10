class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] map = new int[128];
        for (String word: words2) { 
            int[] curMap = new int[128];
            for (char c: word.toCharArray()) {
                curMap[c]++;
            }
            for (int i = 'a'; i <= 'z'; i++) {
                if (map[i] < curMap[i]) map[i] = curMap[i];
            }
        }

        List<String> res = new ArrayList<>();
        for (String word: words1) {
            if (isUniversal(word, map)) res.add(word);
        }

        return res;
    }

    private boolean isUniversal(String word, int[] map) {
        int[] curMap = new int[128];
        for (char c: word.toCharArray()) {
            curMap[c]++;
        }

        for (int i = 'a'; i <= 'z'; i++) {
            if (curMap[i] < map[i]) return false;
        }

        return true;
    }
}
