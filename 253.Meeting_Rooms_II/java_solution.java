class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals==null||intervals.length==0) return 0;
        
        int n = intervals.length;
        int[] startTimes = new int[n];
        int[] endTimes = new int[n];
        int rooms = 0;
        for(int i = 0; i < n; i++){
            startTimes[i] = intervals[i][0];
            endTimes[i] = intervals[i][1];
        }
        
        Arrays.sort(startTimes);
        Arrays.sort(endTimes);
        
        int endTimePointer = 0;
        for(int i = 0; i < n; i++){
            if(startTimes[i]<endTimes[endTimePointer])
                rooms++;
            else
                endTimePointer++;
        }
        
        return rooms;
    }
}
