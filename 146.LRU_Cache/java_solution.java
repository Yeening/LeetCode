class LRUCache {
    //Using self-defined double-linked List to save Node(key, val), 
    //use a map<key, Node> to save nodes' addresses
    int capacity;
    int occupied;
    Map<Integer, Node> nodeMap = new HashMap<>();
    Node frontEnd = new Node(-1,-1), rearEnd = new Node(-1,-1);
    
    class Node{ 
        //Double linked list node to save pair values
        int key;
        int val;
        Node prev = null;
        Node next = null;
        
        public Node(int key, int val){
            this.val = val;
            this.key = key;
        }
    }
    
    public void removeFromList(Node current){
        current.prev.next = current.next;
        current.next.prev = current.prev;
    }
    
    public void addToList(Node current){
        current.prev = this.rearEnd.prev;
        current.next = this.rearEnd;
        current.prev.next = current;
        current.next.prev = current;
    }
    
    public LRUCache(int capacity) {
        Map<Integer, Integer> map = new HashMap<>();
        this.frontEnd.next = this.rearEnd;
        this.rearEnd.prev = this.frontEnd;
        this.capacity = capacity;
        this.occupied = 0;
    }
    
    public int get(int key) {
        if(this.nodeMap.containsKey(key)){
            //refresh node
            Node current = this.nodeMap.get(key);
            removeFromList(current);
            addToList(current);
            
            //return val
            return current.val;
        } 
        else return -1;
    }
    
    public void put(int key, int value) {
        
        if(this.nodeMap.containsKey(key)){
            //already exists
            Node oldNode = this.nodeMap.get(key);
            removeFromList(oldNode);
            this.nodeMap.remove(key);
            this.occupied--;
        }
        
        Node newNode = new Node(key,value);
        this.nodeMap.put(key, newNode);
        addToList(newNode);
        this.occupied++;
        
        if(this.occupied>this.capacity){
            //fully occupied
            Node toRemove = this.frontEnd.next;
            removeFromList(toRemove);
            this.nodeMap.remove(toRemove.key);
            this.occupied--;
        }
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */


// Solution 2: 
class LRUCache {
    
    class Node {
        Node prev;
        Node next;
        int key;
        Node(Node prev, Node next, int key) {
            this.prev = prev;
            this.next = next;
            this.key = key;
        }
    }
    
    Node keyListHead;
    Node keyListTail;
    int capacity;
    Map<Integer, Integer> keyValue;
    Map<Integer, Node> keyNode;

    public LRUCache(int capacity) {
        keyListHead = new Node(null, null, -1);
        keyListTail = new Node(keyListHead, null, -1);
        keyListHead.next = keyListTail;
        this.keyNode = new HashMap<>();
        this.keyValue = new HashMap<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (keyValue.containsKey(key)) {
            removeNode(keyNode.get(key));
            addNode(keyNode.get(key));
            return keyValue.get(key);
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if (keyValue.containsKey(key)) {
            keyValue.put(key, value);
            removeNode(keyNode.get(key));
            addNode(keyNode.get(key));
        } else {
            keyValue.put(key, value);
            Node newNode = new Node(null, null, key);
            keyNode.put(key, newNode);
            addNode(newNode);
        }
        if (keyValue.size() == capacity + 1){
            Node toRemove = keyListHead.next;
            removeNode(toRemove);
            keyValue.remove(toRemove.key);
            keyNode.remove(toRemove.key);
        }
    }
        
    private void removeNode(Node node) {
        if (node == null) return;
        if (node.prev != null) node.prev.next = node.next;
        if (node.next != null) node.next.prev = node.prev;
    }
    
    private void addNode(Node node) {
        Node prevNode = keyListTail.prev;
        if (prevNode != null) {
            prevNode.next = node;
        }
        node.prev = prevNode;
        node.next = keyListTail;
        keyListTail.prev = node;
    }
}
