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

    private HashBucketNode find(HashBucketNode bucket, int key) {
        HashBucketNode curr = bucket, prev = null;
        while (curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
}