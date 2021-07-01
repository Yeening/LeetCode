// Greedy
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, (o1, o2) -> o1[1] - o2[1]);
        int nonOverLaps = 1, lastEnd = intervals[0][1];
        for (int[] i: intervals) {
            if (i[0] >= lastEnd) {
                nonOverLaps++;
                lastEnd = i[1];
            }
        }
        return intervals.length - nonOverLaps;
    }
}
