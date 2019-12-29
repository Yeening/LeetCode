//Double-end BFS, 15ms, 93%
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> visited = new HashSet<>();
        Set<String> wordSet = new HashSet<>(wordList);
        int length = 2;
        if(!wordList.contains(endWord)) return 0;
        Set<String> beginSet = new HashSet<>(), endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);

        while(!beginSet.isEmpty()){
            if(beginSet.size()>endSet.size()){
                //swap begin and end sets
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }
            Set<String> temp = new HashSet<String>();
            for(String word:beginSet){
                char[] charArray = word.toCharArray();
                for(int i = 0; i < charArray.length; i++){
                    char oldChar = charArray[i];
                    for(char c = 'a'; c <='z'; c++){
                        charArray[i] = c;
                        String newWord = new String(charArray);
                        //the ladder connects
                        if(endSet.contains(newWord)){return length;} 
                        //else, add word to beginSet
                        if(!visited.contains(newWord)&&wordSet.contains(newWord)){
                            temp.add(newWord);
                            visited.add(newWord);
                        }
                    }
                    charArray[i] = oldChar;
                }
            }
            beginSet = temp;
            length++;
        }
        return 0;
    }
}
