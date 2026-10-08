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

    private BucketNode addBucketAfter(BucketNode newBucket, BucketNode prevBucket) {
        newBucket.next = prevBucket.next;
        newBucket.prev = prevBucket;
        prevBucket.next.prev = newBucket;
        prevBucket.next = newBucket;
        countBucket.put(newBucket.count, newBucket);
        return newBucket;
    }

    private void removeBucket(BucketNode bucket) {
        bucket.prev.next = bucket.next;
        bucket.next.prev = bucket.prev;
        countBucket.remove(bucket.count);
    }

    public void inc(String key) {
        int count = keyCount.getOrDefault(key, 0);
        keyCount.put(key, count + 1);

        BucketNode curBucket = countBucket.get(count);
        BucketNode nextBucket = countBucket.get(count + 1);

        if (nextBucket == null) {
            nextBucket = addBucketAfter(new BucketNode(count + 1), curBucket == null ? head : curBucket);
        }
        nextBucket.keys.add(key);

        if (curBucket != null) {
            curBucket.keys.remove(key);
            if (curBucket.keys.isEmpty()) {
                removeBucket(curBucket);
            }
        }
    }
}