class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) return new int[][] {newInterval};

        boolean inserted = false;
        LinkedList<int[]> newIntervals = new LinkedList<>();
        if (intervals[0][0] >= newInterval[0]) {
            newIntervals.add(newInterval);
            inserted = true;
        } else {
            newIntervals.add(intervals[0]);
        }

        for (int i = 0; i < intervals.length; i++) {
            int[] last = newIntervals.getLast();
            int[] cur = intervals[i];
            if (!inserted) {
                if (cur[0] >= newInterval[0]) {
                    cur = newInterval;
                    inserted = true;
                    i--;
                }
            }
            if (cur[0] <= last[1]) {
                last[1] = Math.max(last[1], cur[1]);
            } else {
                newIntervals.add(cur);
            }
        }

        if (!inserted) {
            int[] last = newIntervals.getLast();
            if (newInterval[0] <= last[1]) {
                last[1] = Math.max(last[1], newInterval[1]);
            } else {
                newIntervals.add(newInterval);
            }
        }

        return newIntervals.toArray(new int[][]{});
    }
}
