class Solution {
    public int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 == 1) {return new int[0];}
        TreeMap<Integer, Integer> numCount = new TreeMap<>();
        int[] ori = new int[changed.length / 2];
        int index = 0;
        for (int num: changed) {
            numCount.put(num, numCount.getOrDefault(num, 0) + 1);
        }
        for (int num: numCount.keySet()) {
            Integer doubleCount = numCount.get(num + num), 
                    curCount = numCount.get(num);
            if (curCount == 0) {continue;}
            if (doubleCount == null || doubleCount < curCount) {
                return new int[0];
            }
            for (int j = 0; j < numCount.get(num); j++) {
                ori[index++] = num;
                numCount.put(num + num, numCount.get(num + num) - 1);
            }
            numCount.put(num + num, doubleCount - curCount);
        }
        if (index == ori.length) {return ori;}
        assert(index == ori.length): "index: " + index;
        // return ori;
        return new int[0];
    }
}
