/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 * guess("wordss") -> matchNum
 *   for word in "wordss".match(matchNum):
       guess("dordss"):
         if guess("dordss") ==  matchNum:
            matched[0] = "!w!d";
         else if guess("dordss") ==  matchNum - 1:
            matched[0] = 'w';
         else if guess("dordss") ==  matchNum + 1:
            matched[0] = 'd'
         else if guess("dordss") == 6:
            return "dordss"
    "aa...", "aa...", "aa..."
    "azzzzz"
["abcdef","acdefg","adefgh","aefghi","afghij","aghijk","ahijkl","aijklm","ajklmn","aklmno","almnoz","anopqr","azzzzz"]
abcdef：1

 * 
 */
// time: O(N), space: O(lengthOfWord * 26 + N)
// explaination: https://leetcode.com/problems/guess-the-word/discuss/133862/Random-Guess-and-Minimax-Guess-with-Comparison
class Solution {
    public void findSecretWord(String[] wordlist, Master master) {
        List<String> candidates = 
            new ArrayList<>(Arrays.asList(wordlist));
        int guessMatch = 0;
        for (int i = 0; i < 10 && guessMatch != 6; i++) {
            int[][] charOccur = new int[6][26];
            for (String word: candidates) {
                for (int j = 0; j < 6; j++) {
                    charOccur[j][word.charAt(j) - 'a']++;
                }
            }
            String guessWord = "";
            int maxScore = 0;
            for (String word: candidates) {
                int wordScore = score(word, charOccur);
                if (wordScore > maxScore) {
                    maxScore = wordScore;
                    guessWord = word;
                }
            }
            guessMatch = master.guess(guessWord);
            List<String> nextCandidates = new ArrayList<>();
            for (String word: candidates) {
                if (!word.equals(guessWord) && 
                     match(word, guessWord) == guessMatch) {
                    nextCandidates.add(word);
                }
            }
            candidates = nextCandidates;
        }
        
        
    }
    
    private int score(String word, int[][] charOccur) {
        int score = 0;
        for (int i = 0; i < 6; i++) {
            score += charOccur[i][word.charAt(i) - 'a'];
        }
        return score;
    }
    
    private int match(String a, String b) {
        int match = 0;
        for (int i = 0; i < 6; i++) {
            if (a.charAt(i) == b.charAt(i)) {match++;}
        }
        return match;
    }
}
