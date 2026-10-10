class HashBucketNode {
    int key;
    int value;
    HashBucketNode next;

    HashBucketNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class DesignHashMap {
    private static final int SIZE = 1009;
    private final HashBucketNode[] buckets;

    public DesignHashMap() {
        buckets = new HashBucketNode[SIZE];
    }

    private int getHash(int key) {
        return key % SIZE;
    }

    public void put(int key, int value) {
        int index = getHash(key);
        if (buckets[index] == null) {
            buckets[index] = new HashBucketNode(-1, -1);
        }
        HashBucketNode prev = find(buckets[index], key);
        if (prev.next == null) {
            prev.next = new HashBucketNode(key, value);
        } else {
            prev.next.value = value;
        }
    }

    public int get(int key) {
        int index = getHash(key);
        if (buckets[index] == null) return -1;
        HashBucketNode prev = find(buckets[index], key);
        return prev.next == null ? -1 : prev.next.value;
    }

    public void remove(int key) {
        int index = getHash(key);
        if (buckets[index] == null) return;
        HashBucketNode prev = find(buckets[index], key);
        if (prev.next != null) {
            prev.next = prev.next.next;
        }
    }

    private HashBucketNode find(HashBucketNode bucket, int key) {
        HashBucketNode curr = bucket, prev = null;
        while (curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
}