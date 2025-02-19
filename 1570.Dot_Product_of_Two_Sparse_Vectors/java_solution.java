// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);

// Solution 1: Map
class SparseVector {
    public Map<Integer, Integer> map = new HashMap<>();
    
    SparseVector(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                map.put(i, nums[i]);
            }
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        Map<Integer, Integer> map2 = vec.map;
        int res = 0;
        for(Map.Entry<Integer, Integer> e: map.entrySet()) {
            int key = e.getKey();
            if (map2.containsKey(key)) {
                res += map2.get(key) * e.getValue();
            }
        }
        return res;
    }
}

// Soution 2: List
class SparseVector {
    public List<Pair<Integer, Integer>> list = new ArrayList<>();
    
    SparseVector(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                list.add(new Pair(i, nums[i]));
            }
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        List<Pair<Integer, Integer>> list2 = vec.list;
        int res = 0, i = 0, j = 0;
        while (i < list.size() && j < list2.size()) {
            Pair<Integer, Integer> p1 = list.get(i), p2 = list2.get(j);
            int key1 = p1.getKey(), key2 = p2.getKey();
            if (key1 < key2) {
                i++;
            } else if (key1 > key2) {
                j++;
            } else if (key1 == key2) {
                res += p1.getValue() * p2.getValue();
                i++;
                j++;
            }
        }
        return res;
    }
}
