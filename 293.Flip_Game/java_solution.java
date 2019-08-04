
class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new LinkedList<>();
        for(int i = s.indexOf("++"); i >=0; i = s.indexOf("++", i + 1)){
            res.add(s.substring(0,i) + "--" + s.substring(i+2));
        }
        return res;
    }
}
