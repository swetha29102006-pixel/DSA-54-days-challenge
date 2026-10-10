class SetBucketNode {
    int key;
    SetBucketNode next;

    SetBucketNode(int key) {
        this.key = key;
    }
}

public class DesignHashSet {
    private static final int SIZE = 1009;
    private final SetBucketNode[] buckets;
}