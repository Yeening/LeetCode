class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits==null || digits.length()==0) return new LinkedList<>();
        LinkedList<String> sList = new LinkedList<>();
        sList.add("");
        List<char[]> dic = new ArrayList<>();
        dic.add(new char[]{'a', 'b', 'c'});
        dic.add(new char[]{'d', 'e', 'f'});
        dic.add(new char[]{'g', 'h', 'i'});
        dic.add(new char[]{'j', 'k', 'l'});
        dic.add(new char[]{'m', 'n', 'o'});
        dic.add(new char[]{'p', 'q', 'r', 's'});
        dic.add(new char[]{'t', 'u', 'v'});
        dic.add(new char[]{'w', 'x', 'y', 'z'});
        for(char number: digits.toCharArray()){
            char[] chars = dic.get((int)(number - '2'));
            int count = sList.size();
            for(int i = 0; i < count; i++){
                String lastS = sList.poll();
                for(char c: chars){
                    sList.add(lastS+c);
                }
            }
        }
        return sList;
    }
}
