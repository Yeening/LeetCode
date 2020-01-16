//My solution, sorting, 20%
class AutocompleteSystem {
    
    class StringCount{
        String s;
        int c;
        public StringCount(String _s, int _c){s = _s; c = _c;}
    }
    
    class TrieNode{
        Map<Character, TrieNode> children = new HashMap<>();
        Map<String, Integer> sentenceCount = new HashMap<>();
    }
    
    TrieNode root = new TrieNode();
    TrieNode inputCurrent;
    String prefix = "";
    
    private void addToSystem(String sentence, int time){
        TrieNode current = root;
        for(char c: sentence.toCharArray()){
            if(!current.children.containsKey(c)){
                current.children.put(c, new TrieNode());
            }
            current = current.children.get(c);
            current.sentenceCount.put(sentence, current.sentenceCount.getOrDefault(sentence, 0) + time);
        }
    }
    
    public AutocompleteSystem(String[] sentences, int[] times) {
        inputCurrent = root;
        for(int i = 0; i < sentences.length; i++){
            addToSystem(sentences[i], times[i]);
        }
    }
    
    public List<String> input(char c) {
        List<String> res = new ArrayList<>();
        List<StringCount> temp = new ArrayList<>();
        if(c=='#'){
            addToSystem(prefix, 1);
            prefix = "";
            inputCurrent = root;
        }
        else{
            if(!inputCurrent.children.containsKey(c)){
                inputCurrent.children.put(c, new TrieNode());
                inputCurrent = inputCurrent.children.get(c);
            }
            else{
                inputCurrent = inputCurrent.children.get(c);
                for(String s: inputCurrent.sentenceCount.keySet()){
                    temp.add(new StringCount(s, inputCurrent.sentenceCount.get(s)));
                }
                Collections.sort(temp, (a, b)->compare(a, b));
                for(int i = 0; i < 3 && i < temp.size(); i++){
                    res.add(temp.get(i).s);
                }
            }
            prefix += c;
        }
        return res;
    }
    
    private int compare(StringCount a, StringCount b){
        if(a.c==b.c) return a.s.compareTo(b.s);
        else return b.c-a.c;
    }
    
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */
