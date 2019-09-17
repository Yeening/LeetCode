class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for(String s:strs){
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
        return new ArrayList<>(map.values());
    }
}
