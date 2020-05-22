class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for(String s:strs){
            //Sorting string in Java
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String sorted = String.valueOf(c);
            if(map.containsKey(sorted)){
                map.get(sorted).add(s);
            }
            else{
                List<String> list = new LinkedList<>();
                list.add(s);
                map.put(sorted,list);
            }
        }
        //map.values() return a Collection obj
        return new ArrayList<>(map.values());
    }
}

//Solution2: make the O(Nlog(N)) sorting O(N)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs==null||strs.length==0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(String s: strs){
            char[] ca = new char[26];
            for(char c: s.toCharArray()){
                ca[c - 'a']++;
            }
            String cur = String.valueOf(ca);
            if(!map.containsKey(cur)){
                map.put(cur, new ArrayList<>());
            }
            map.get(cur).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
