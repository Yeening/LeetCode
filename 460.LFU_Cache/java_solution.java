// https://labuladong.gitbook.io/algo/mu-lu-ye-1/mu-lu-ye-2/lfu
class LFUCache {
    int size;
    int capacity;
    int leastUsage;
    Map<Integer, Integer> keyVal;
    Map<Integer, Integer> keyFreq;
    Map<Integer, LinkedHashSet<Integer>> freqToKeys;
    public LFUCache(int capacity) {
        size = 0;
        leastUsage = Integer.MAX_VALUE;
        this.capacity = capacity;
        keyVal = new HashMap<>();
        keyFreq = new HashMap<>();
        freqToKeys = new HashMap<>();
    }

    public int get(int key) {
        if (!keyVal.containsKey(key)) {
            return -1;
        }
        int freq = keyFreq.get(key) + 1;
        // update keyFreq
        keyFreq.put(key, freq);
        // update freqToKeys
        freqToKeys.get(freq - 1).remove(key);
        freqToKeys.putIfAbsent(freq, new LinkedHashSet<>());
        freqToKeys.get(freq).add(key);
        // update leastUsage
        if (freq == leastUsage + 1 && freqToKeys.get(leastUsage).isEmpty()) {
            leastUsage++;
        }
        return keyVal.get(key);
    }

    public void put(int key, int value) {
        if (capacity == 0) return;
        get(key);
        if (!keyVal.containsKey(key)) {
            if (size == capacity) {
                int LFU = freqToKeys.get(leastUsage).iterator().next();
                freqToKeys.get(leastUsage).remove(LFU);
                keyVal.remove(LFU);
                keyFreq.remove(LFU);
            } else {
                size++;
            }
            leastUsage = 1;
            keyFreq.put(key, 1);
            freqToKeys.putIfAbsent(1, new LinkedHashSet<>());
            freqToKeys.get(1).add(key);
        }
        // update keyVal
        keyVal.put(key, value);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
