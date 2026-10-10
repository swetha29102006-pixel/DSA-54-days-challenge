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

    public DesignHashSet() {
        buckets = new SetBucketNode[SIZE];
    }

    private int getHash(int key) {
        return key % SIZE;
    }

    private SetBucketNode find(SetBucketNode bucket, int key) {
        SetBucketNode curr = bucket, prev = null;
        while (curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
}