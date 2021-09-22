// Dijkstra: weighted BFS, using heap to replace the queue
// https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247492167&idx=1&sn=bc96c8f97252afdb3973c7d760edb9c0&chksm=9bd41c4faca3955959c4a35ce89f67ed117f202de11a6d4ead82519c16a60a0e054f7c358750#rd

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[][] adjMat = new int[n+1][n+1];
        for (int i = 0 ; i < n + 1; i++) Arrays.fill(adjMat[i], -1);
        for (int[] time: times) {
            int start = time[0], dest = time[1], cost = time[2];
            adjMat[start][dest] = cost;
        }

        // state: [node, timeFromStart]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (Integer.compare(a[1], b[1])));
        pq.offer(new int[]{k, 0});

        int[] timeFromStart = new int[n+1];
        Arrays.fill(timeFromStart, Integer.MAX_VALUE);
        timeFromStart[k] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curNode = cur[0], curTime = cur[1];
            if (curTime > timeFromStart[curNode]) continue;

            for (int next = 1; next <= n; next++) {
                int timeToNext = adjMat[curNode][next];
                if (timeToNext == -1 || 
                    timeToNext + curTime >= timeFromStart[next]) {
                    continue;
                }
                timeFromStart[next] = timeToNext + curTime;
                pq.offer(new int[]{next, timeToNext + curTime});
            } 
        }

        int maxTime = 0;
        for (int i = 1; i < timeFromStart.length; i++) {
            maxTime = Math.max(maxTime, timeFromStart[i]);
        }

        return maxTime == Integer.MAX_VALUE? -1: maxTime;
    }

}
