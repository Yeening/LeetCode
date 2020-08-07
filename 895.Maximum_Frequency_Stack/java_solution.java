class FreqStack {
        // Using bucket sorting to store the ints, store multiple times for every item
        Map<Integer, Integer> counts = new HashMap<>();
        Map<Integer, Stack<Integer>> freqBuckets = new HashMap<>();
        int maxFreq = 0;

        public FreqStack() {

        }

        public void push(int x) {
            int freq = counts.getOrDefault(x, 0)+1;
            counts.put(x, freq);
            maxFreq = Math.max(maxFreq, freq);
            if(!freqBuckets.containsKey(freq)){
                freqBuckets.put(freq, new Stack<>());
            }
            freqBuckets.get(freq).push(x);
        }

        public int pop() {
            if(freqBuckets.get(maxFreq) == null || freqBuckets.get(maxFreq).isEmpty()) return -1;
            Stack<Integer> maxBucket = freqBuckets.get(maxFreq);
            int res = maxBucket.pop();
            counts.put(res,counts.get(res)-1);
            if(maxBucket.isEmpty()){
                maxFreq--;
            }
            return res;
        }
    }

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */
