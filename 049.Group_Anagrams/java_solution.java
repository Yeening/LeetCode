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
