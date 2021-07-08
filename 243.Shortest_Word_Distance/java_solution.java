class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int occ1 = -1, occ2 = -1, distance = wordsDict.length;
        for (int i = 0 ; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1)) {
                if (occ2 >= 0) distance = Math.min(distance, i - occ2);
                occ1 = i;
            } else if (wordsDict[i].equals(word2)) {
                if (occ1 >= 0) distance = Math.min(distance, i - occ1);
                occ2 = i;
            }
        }
        return distance;
    }
}
