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

//
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word: words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> pq = new PriorityQueue<>(
            (a, b) -> compare(b, a, wordCount));
        for (String word: wordCount.keySet()) {
            if (pq.size() < k) {
                pq.offer(word);
            } else if (compare(word, pq.peek(), wordCount) < 0){
                pq.offer(word);
                pq.poll();
            }
        }
        LinkedList<String> res = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            res.addFirst(pq.poll());
        }
        // Collections.reverse(res);
        return res;
    }
    
    // decreasing to count, then lexicographical order
    private int compare(String a, String b, Map<String, Integer> wordCount) {
        int countCompare = wordCount.get(b) - wordCount.get(a);
        if (countCompare == 0) {
            return a.compareTo(b);
        } else {
            return countCompare;
        }
    }
}
