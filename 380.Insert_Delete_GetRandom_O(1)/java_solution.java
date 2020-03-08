class RandomizedSet {
    Map<Integer, Integer> map;
    ArrayList<Integer> list;
    Random rand;
    int size;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        size = 0;
        rand = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        map.put(val, size);
        list.add(val);
        size++;
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        int pos = map.get(val);
        
        list.set(pos, list.get(size-1)); //swap the end num to current pos
        map.put(list.get(pos), pos);
        
        list.remove(size-1);
        map.remove(val);
        size--;
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        if(size==0) return -1;
        return list.get(rand.nextInt(size));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
