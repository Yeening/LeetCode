class Solution {
    // time: O(NlogN), space: O(N), N: keytime.length
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<Integer>> nameTime = new HashMap<>();
        for (int i = 0; i < keyName.length; i++) {
            nameTime.putIfAbsent(keyName[i], new ArrayList<>());
            nameTime.get(keyName[i]).add(parseTime(keyTime[i]));
        }
        List<String> res = new ArrayList<>();
        for (String name: nameTime.keySet()) {
            List<Integer> curList = nameTime.get(name);
            Collections.sort(curList);
            for (int i = 2; i < curList.size(); i++) {
                if (curList.get(i) - curList.get(i-2) <= 60) {
                    res.add(name);
                    break;
                }
            }
        }
        Collections.sort(res);
        return res;
    }
    
    private int parseTime(String time) {
        return Integer.parseInt(time.substring(0,2)) * 60 + 
            Integer.parseInt(time.substring(3));
    }
}
