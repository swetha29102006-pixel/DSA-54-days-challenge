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

    public void add(int key) {
        int index = getHash(key);
        if (buckets[index] == null) {
            buckets[index] = new SetBucketNode(-1);
        }
        SetBucketNode prev = find(buckets[index], key);
        if (prev.next == null) {
            prev.next = new SetBucketNode(key);
        }
    }

    public void remove(int key) {
        int index = getHash(key);
        if (buckets[index] == null) return;
        SetBucketNode prev = find(buckets[index], key);
        if (prev.next != null) {
            prev.next = prev.next.next;
        }
    }

    public boolean contains(int key) {
        int index = getHash(key);
        if (buckets[index] == null) return false;
        SetBucketNode prev = find(buckets[index], key);
        return prev.next != null;
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