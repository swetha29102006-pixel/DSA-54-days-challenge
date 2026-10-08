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

public class LFUCache {
    private final int capacity;
    private int minFreq;
}