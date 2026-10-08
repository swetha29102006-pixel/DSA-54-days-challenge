import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class BucketNode {
    int count;
    Set<String> keys;
    BucketNode prev;
    BucketNode next;

    BucketNode(int count) {
        this.count = count;
        this.keys = new HashSet<>();
    }
}

public class AllOoneDataStructure {
    private final BucketNode head;
    private final BucketNode tail;
    private final Map<String, Integer> keyCount;
    private final Map<Integer, BucketNode> countBucket;

    public AllOoneDataStructure() {
        head = new BucketNode(0);
        tail = new BucketNode(0);
        head.next = tail;
        tail.prev = head;
        keyCount = new HashMap<>();
        countBucket = new HashMap<>();
    }
}