import java.util.HashMap;
import java.util.Map;

class LFUNode {
    int key, val, freq;
    LFUNode prev, next;
    LFUNode(int key, int val) {
        this.key = key;
        this.val = val;
        this.freq = 1;
    }
}

class LFUList {
    LFUNode head, tail;
    int size;
    LFUList() {
        head = new LFUNode(0, 0);
        tail = new LFUNode(0, 0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }
    void addNode(LFUNode node) {
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
        size++;
    }
    void removeNode(LFUNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }
    LFUNode removeTail() {
        if (size > 0) {
            LFUNode node = tail.prev;
            removeNode(node);
            return node;
        }
        return null;
    }
}

public class LFUCache {
    private final int capacity;
    private int minFreq;
    private final Map<Integer, LFUNode> keyMap;
    private final Map<Integer, LFUList> freqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.keyMap = new HashMap<>();
        this.freqMap = new HashMap<>();
    }

    private void updateFreq(LFUNode node) {
        int oldFreq = node.freq;
        LFUList oldList = freqMap.get(oldFreq);
        oldList.removeNode(node);
        if (oldFreq == minFreq && oldList.size == 0) {
            minFreq++;
        }
        node.freq++;
        freqMap.computeIfAbsent(node.freq, k -> new LFUList()).addNode(node);
    }
}