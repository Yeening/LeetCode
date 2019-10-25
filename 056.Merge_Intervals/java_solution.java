class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length==0||intervals[0].length==0) return intervals;
        // Sort the intervals with begin index
        Arrays.sort(intervals, (i1,i2) -> Integer.compare(i1[0],i2[0]));
        int[] current = intervals[0];
        List<int[]> res = new ArrayList<>();
        res.add(current);
        for(int[] interval: intervals){
            if(interval[0]<=current[1]){
                current[1] = Math.max(interval[1],current[1]);
            }
            else{
                current = interval;
                res.add(current);
            }
        }
        return res.toArray(new int[res.size()][2]);
    }
}
