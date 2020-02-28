class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<String, Integer>> min_heap = new PriorityQueue<>(
        (a,b)->a.getValue()==b.getValue()?b.getKey().compareTo(a.getKey()):a.getValue() - b.getValue());
        for(String s: words){
            map.put(s, map.getOrDefault(s, 0)+1);         
        }
        for(Map.Entry<String, Integer> entry: map.entrySet()){
            min_heap.offer(entry);
            if(min_heap.size()>k) min_heap.poll();
        }
        List<String> res = new LinkedList<>();
        while(!min_heap.isEmpty()){
            res.add(0, min_heap.poll().getKey());
        }
        return res;
    }
}
