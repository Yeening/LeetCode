class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        //bucket sort
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int num: nums){
            freqMap.put(num, freqMap.getOrDefault(num, 0)+1);
        }
        
        //initializing array of list
        List<Integer>[] buckets = new List[nums.length+1];
        
        for(int key: freqMap.keySet()){
            int freq = freqMap.get(key);
            if(buckets[freq]==null) buckets[freq] = new ArrayList<>();
            buckets[freq].add(key);
        }
        
        int count = 0;
        List<Integer> res = new ArrayList<>();
        for(int i = buckets.length-1; i>=0&&count<k; i--){
            if(buckets[i]==null) continue;
            for(int j = 0; j < buckets[i].size() && count < k; j++){
                res.add(buckets[i].get(j));
                count++;
            }
        }
        
        return res;
    }
}
