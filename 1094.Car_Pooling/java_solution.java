// solution 1: bucket sort
class Solution {
    // [2, 1, 5] [3, 3, 7]
    /*
    1: 2 on
    3: 3 on
    5: 2 off
    7: 3 off
    [1:2, 3:3, 5:-2, 7:-3]
    */
    // time: O(n + tripRange) space: O(tripRange)
    public boolean carPooling(int[][] trips, int capacity) {
        int[] update = new int[1001];
        int passengerSum = 0;
        for (int[] trip: trips) {
            update[trip[1]] += trip[0];
            update[trip[2]] -= trip[0];
        }
        for (int i: update) {
            passengerSum += i;
            if (passengerSum > capacity) {return false;}
        }
        return true;
    }
}

// solution 2: sort + priority queue
    // time: O(nlogn) space: O(n)
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (a, b) -> Integer.compare(a[1], b[1]));
        // item[0]: time, item[1]: passenger count, all item represent off
        PriorityQueue<int[]> prev = new PriorityQueue<>((a,b) -> Integer.compare(a[2], b[2]));
        int pSum = 0;
        
        for (int[] trip: trips) {
            int curTime = trip[1];
            while (!prev.isEmpty() && prev.peek()[2] <= curTime) {
                int offCount = prev.poll()[0];
                pSum -= offCount;
            }
            pSum += trip[0];
            prev.offer(trip);
            if (pSum > capacity) {return false;}
        }
        
        return true;
    }
}

// solution 3: treemap
// time: O(nlog2n) space: O(2n)
public boolean carPooling(int[][] trips, int capacity) {
    TreeMap<Integer, Integer> passengerUpdates = new TreeMap<>();
    for (int[] trip: trips) {
        int from = trip[1], to = trip[2], passenger = trip[0];
        passengerUpdates
            .put(from, passengerUpdates.getOrDefault(from, 0) + passenger);
        passengerUpdates
            .put(to, passengerUpdates.getOrDefault(to, 0) - passenger);
    }
    int passengerSum = 0;
    for (Map.Entry<Integer, Integer> entry: passengerUpdates.entrySet()) {
        passengerSum += entry.getValue();
        if (passengerSum > capacity) {
            return false;
        }
    }
    return true;
}
