class MyHashMap {
    class Node{
        int val;
        int key;
        Node next = null;
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    Node[] map;
    final int HASH_SIZE = 10000;

    /** Initialize your data structure here. */
    public MyHashMap() {
        map = new Node[HASH_SIZE];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hashKey = key %  HASH_SIZE;
        if(map[hashKey] == null){
            map[hashKey] = new Node(-1, -1);
            map[hashKey].next = new Node(key, value);
        } else {
            Node prev = findNode(map[hashKey], key);
            if(prev.next == null){
                prev.next = new Node(key, value);
            } else {
                prev.next.val = value;
            }
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hashKey = key %  HASH_SIZE;
        if(map[hashKey] == null) return -1;
        else{
            Node prev = findNode(map[hashKey], key);
            if(prev.next == null) return -1;
            else return prev.next.val;
        }
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hashKey = key %  HASH_SIZE;
        if(map[hashKey] == null) return;
        Node prev = findNode(map[hashKey], key);
        if(prev.next == null) return;
        prev.next = prev.next.next;
    }
    
    private Node findNode(Node target, int key) {
        Node prev = target;
        target = target.next;
        while(target != null && target.key != key){
            prev = target;
            target = target.next;
        }
        return prev;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
