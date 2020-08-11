class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < N; i++){
            String key = Arrays.toString(cells);
            if(!map.containsKey(key)){
                map.put(key, i);
                cells = prisonNextDay(cells);
            }
            else{
                int firstOccr = map.get(key);
                int T = i - firstOccr;
                int mod = (N - firstOccr) % T;
                for(int j = 0; j < mod; j++){
                    cells = prisonNextDay(cells);
                }
                return cells;
            }
        }
        return cells;
    }

    private int[] prisonNextDay(int[] cells){
        int[] nextDay = new int[cells.length];
        for(int i = 1; i < nextDay.length-1; i++){
            nextDay[i] = cells[i-1] ^ cells[i+1] ^ 1;
        }
        return nextDay;
    }
}
