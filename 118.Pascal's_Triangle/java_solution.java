// Solution 1: 0ms
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < numRows; i++){
            List<Integer> cur = new ArrayList<>();
            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i){
                    cur.add(1);
                }
                else{
                    List<Integer> prev = res.get(i-1);
                    cur.add(prev.get(j-1) + prev.get(j));
                }
            }
            res.add(cur);
        }
        return res;
    }
}

// Solution 2: 0ms
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        for(int i = 0; i < numRows; i++){
            row.add(1);
            for(int j = i - 1; j > 0; j--){
                row.set(j, row.get(j-1) + row.get(j));
            }
            res.add(new ArrayList<>(row));
        }
        return res;
    }
}
