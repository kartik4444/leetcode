class Node {

    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }

    public Node() {
    }

}

class LRUCache {
    Map<Integer, Node> mp = new HashMap<>();
    int capacity;
    int size;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new Node();
        tail = new Node();

       tail.next = head;
       head.prev = tail;

    }

    public int get(int key) {
        if (!mp.containsKey(key))
            return -1;

        Node curr = mp.get(key);
        moveNodeToFront(curr);
        return curr.val;
    }

    public void put(int key, int value) {
        if (mp.containsKey(key)) {
            //update its value
            Node curr = mp.get(key);
            curr.val = value;
            moveNodeToFront(curr);

        } else {
            if (size == capacity) {
                Node lru = tail.next;
                removeNode(lru);
                mp.remove(lru.key);
                size--;
            } 

            Node curr = new Node(key,value);
            addNodetoFront(curr);
            mp.put(key,curr);
            size++;

        }
    }

     private void removeNode(Node curr){
       curr.prev.next = curr.next;
       curr.next.prev = curr.prev;
    }

    private void moveNodeToFront(Node curr) {
        removeNode(curr);
        addNodetoFront(curr);
    }

   private void addNodetoFront(Node curr) {

    curr.next = head;
    curr.prev = head.prev;

    head.prev.next = curr;
    head.prev = curr;
}



}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */