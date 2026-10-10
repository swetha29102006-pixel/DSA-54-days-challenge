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
}