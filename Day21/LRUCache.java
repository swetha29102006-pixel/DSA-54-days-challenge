import java.util.HashMap;
import java.util.Map;

class LRUNode {
    int key;
    int val;
    LRUNode prev;
    LRUNode next;
    LRUNode() {}
    LRUNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

public class LRUCache {
    private final int capacity;
    private final Map<Integer, LRUNode> map;
    private final LRUNode head;
    private final LRUNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new LRUNode(0, 0);
        this.tail = new LRUNode(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    private void remove(LRUNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertToHead(LRUNode node) {
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        LRUNode node = map.get(key);
        remove(node);
        insertToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            LRUNode node = map.get(key);
            node.val = value;
            remove(node);
            insertToHead(node);
        } else {
            if (map.size() == capacity) {
                LRUNode lru = tail.prev;
                map.remove(lru.key);
                remove(lru);
            }
            LRUNode newNode = new LRUNode(key, value);
            map.put(key, newNode);
            insertToHead(newNode);
        }
    }
}