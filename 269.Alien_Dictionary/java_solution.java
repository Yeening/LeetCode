// [Topological Sorting Explanation](https://www.geeksforgeeks.org/topological-sorting/)
// Build a graph to store the graph order and then use topological sorting.
// Use an int-typed visited array to distinguish three status: visited, visiting, never visited.

class Solution {
    Map<Character, ArrayList<Character>> map = new HashMap<>();
    Deque<Character> s = new LinkedList<>(); //Stack for topological sorting
    int[] visited = new int[26];
    
    public String alienOrder(String[] words) {
        if(words.length == 1 && words[0].length() > 1) return words[0];
        for(int i = 0; i < words.length - 1; i++){
            if(!compare(words[i], words[i+1])) //Catch exception when comparing
                return "";
        }
        
        for(char c: map.keySet()){
            if(!topoSort(c))  //Catch exception(cycle in graph) when sorting
                return "";
        }
        StringBuilder sb = new StringBuilder();
        while(!s.isEmpty()){
            sb.append(s.pollFirst());
        }
        return sb.toString();
    }
    
    private boolean compare(String s1, String s2){
        int shortLen = Math.min(s1.length(), s2.length());
        
        for(char c: s1.toCharArray()){
            if(!map.containsKey(c))
                    map.put(c, new ArrayList<>());
        }
        
        for(char c: s2.toCharArray()){
            if(!map.containsKey(c))
                    map.put(c, new ArrayList<>());
        }
        
        for(int i = 0; i < shortLen; i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                //Save topological order c1 -> c2
                map.get(s1.charAt(i)).add(s2.charAt(i));
                return true;
            } 
        }
        //code reaches here implies that the two words are same [0, shortLen)
        //Catch error input like ["abc", "ab"]
        if(s1.length()!=shortLen)
            return false;
        return true;
    }
    
    private boolean topoSort(char c){
        //Topological sorting
        if(visited[c - 'a'] == 2) return true;
        visited[c - 'a'] = 1; //visiting
        for(char n: map.get(c)){ //neighbors
            if(visited[n - 'a'] == 1) return false;
            if(!topoSort(n)) return false;  //false if any neighbor contains a cycle
        }
        s.addFirst(c);
        visited[c - 'a'] = 2; //visited
        return true;
    }
}
