class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        // float[][] arriveProb = new float[n][n];
        Map<Integer, Double>[] adjMaps = new Map[n];
        for (int i = 0; i < edges.length; i++) {
            int pointA = edges[i][0], pointB = edges[i][1];
            // arriveProb[pointA][pointB] = (float)succProb[i];
            // arriveProb[pointB][pointA] = (float)succProb[i];
            if (adjMaps[pointA] == null) 
                adjMaps[pointA] = new HashMap<>();
            if (adjMaps[pointB] == null) 
                adjMaps[pointB] = new HashMap<>();
            adjMaps[pointA].put(pointB, succProb[i]);
            adjMaps[pointB].put(pointA, succProb[i]);
        }
        
        // pq<prob, point>
        PriorityQueue<double[]> pq = new PriorityQueue<>(
            (a,b)->(Double.compare(b[0], a[0])));
        double[] fromStartProb = new double[n];
        fromStartProb[start] = 1;
        pq.offer(new double[]{1, start});
        
        while(!pq.isEmpty()) {
            double[] cur = pq.poll();
            int curPoint = (int)cur[1];
            double curProb = cur[0];
            if (curPoint == end) return curProb;
            if (curProb < fromStartProb[curPoint] || 
               curProb == 0 || adjMaps[curPoint] == null) continue;
            for (int next: adjMaps[curPoint].keySet()) {
                // if (arriveProb[curPoint][next] * curProb > fromStartProb[next]) {
                //     fromStartProb[next] = arriveProb[curPoint][next] * curProb;
                //     pq.offer(new float[]{fromStartProb[next], next});
                // }
                if (adjMaps[curPoint].get(next) * curProb > fromStartProb[next]) {
                    fromStartProb[next] = adjMaps[curPoint].get(next) * curProb;
                    pq.offer(new double[]{fromStartProb[next], next});
                }
            }
        }
        
        return fromStartProb[end];
    }
}
