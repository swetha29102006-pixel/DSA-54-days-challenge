import java.util.HashSet;
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
}