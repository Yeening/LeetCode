//HashMap, beats 84%
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        int left = 0, right = 0;
        Map<String, Integer> wordCount = new HashMap<>();
        Set<String> bannedSet = new HashSet(Arrays.asList(banned));
        paragraph = paragraph.toLowerCase() + ".";
        while(right < paragraph.length()){
            if(paragraph.charAt(right) < 'a'){
                while(left < right && paragraph.charAt(left) < 'a'){
                    left++;
                }
                if(left < right){
                    String word = paragraph.substring(left, right);
                    if(!bannedSet.contains(word)){
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
                left = right;
            }
            right++;
        }        
        String res = "";
        int mostFreq = 0;
        for(String key: wordCount.keySet()){
            int freq = wordCount.get(key);
            if(freq > mostFreq){
                mostFreq = freq;
                res = key;
            }
        }
        return res;
    }
}
