class Solution {
    public List<Integer> partitionLabels(String S) {
        if(S == null || S.length() == 0){
            return null;
        }
        int[] roots = new int[S.length()];
        Map<Character, Integer> lastOccur = new HashMap<>();
        for(int i = 0; i < roots.length; i++){
            lastOccur.put(S.charAt(i), i);
        }
        List<Integer> res = new LinkedList<>();
        int last = 0, lastCount = 1;
        for(int i = 0; i < roots.length; i++){
            last = Math.max(last, lastOccur.get(S.charAt(i)));
            if(last == i){
                res.add(lastCount);
                lastCount = 1;
                last = i+1;
            }
            else{
                lastCount++;
            }
        }
        return res;
    }
}
