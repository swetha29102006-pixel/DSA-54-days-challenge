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
}