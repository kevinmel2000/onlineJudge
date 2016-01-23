public class LRUCache {
    class ListNode {
        int key;
        int val;
        ListNode next;
        ListNode prev;
        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    int size = 0;
    int capacity;
    Map<Integer, ListNode> keyMap = new HashMap<>();
    ListNode head = new ListNode(0,0);
    ListNode tail;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!keyMap.containsKey(key)) {
            return -1;
        }
        
        ListNode cur = keyMap.get(key);
        removeNode(cur);
        addToHead(cur);
        
        return head.next.val;
    }
    
    public void set(int key, int value) {
        if(!keyMap.containsKey(key)) {
            if(size==capacity) {
                keyMap.remove(tail.key);
                removeNode(tail);
                size--;
            }
            
            ListNode n = new ListNode(key, value);
            keyMap.put(key, n);
            addToHead(n);
            size++;
        } else {
            ListNode n = keyMap.get(key);
            n.val = value;
            removeNode(n);
            addToHead(n);
        }
    }
    
    void removeNode(ListNode node) {
        if(node.next==null) {
            tail = node.prev;
            node.prev.next = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }
    
    void addToHead(ListNode node) {
        if(head.next==null) {
            tail=node;
            head.next = node;
            node.prev = head;
        } else {
            node.next = head.next;
            head.next.prev = node;
            node.prev = head;
            head.next = node;
        }
    }
}
