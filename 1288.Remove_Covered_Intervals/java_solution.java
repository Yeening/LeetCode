class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, this::compare);
        int[] lastInterval = intervals[0];
        int res = intervals.length;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][1] <= lastInterval[1]) {
                // interval[i] is covered by lastInterval
                res--;
            } else {
                lastInterval = intervals[i];
            }
        }
        return res;
    }

    private int compare(int[] a, int[] b) {
        if (a[0] == b[0]) {
            return b[1] - a[1];
        } else {
            return a[0] - b[0];
        }
    }
}
