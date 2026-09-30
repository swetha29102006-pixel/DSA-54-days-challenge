// LeetCode 23: Merge k Sorted Lists
import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class MergeKSortedLists {
    /**
     * Merges k sorted linked lists using a Min-Heap PriorityQueue.
     * Time Complexity: O(N log k) where N is total number of nodes.
     * Space Complexity: O(k) for PriorityQueue.
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll();
            curr.next = minNode;
            curr = curr.next;
            if (minNode.next != null) {
                pq.offer(minNode.next);
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode l3 = new ListNode(2, new ListNode(6));
        ListNode[] lists = {l1, l2, l3};

        MergeKSortedLists solution = new MergeKSortedLists();
        ListNode merged = solution.mergeKLists(lists);
        System.out.println("Merged head val: " + (merged != null ? merged.val : "null")); // Output: 1
    }
}