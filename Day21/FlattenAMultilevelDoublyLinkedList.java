/**
 * LeetCode 430: Flatten a Multilevel Doubly Linked List
 * Flatten a multilevel doubly linked list where nodes may have a child pointer to another doubly linked list.
 * Time Complexity: O(N) where N is total number of nodes across all levels.
 * Space Complexity: O(D) where D is maximum depth of child recursion.
 */
class MultiNode {
    public int val;
    public MultiNode prev;
    public MultiNode next;
    public MultiNode child;

    public MultiNode() {}
    public MultiNode(int val) {
        this.val = val;
    }
}

public class FlattenAMultilevelDoublyLinkedList {
    public MultiNode flatten(MultiNode head) {
        if (head == null) return null;
        flattenDFS(head);
        return head;
    }

    // DFS helper to recursively flatten child lists
    private MultiNode flattenDFS(MultiNode node) {
        MultiNode curr = node;
        MultiNode last = null;

        while (curr != null) {
            MultiNode next = curr.next;
            if (curr.child != null) {
                MultiNode childTail = flattenDFS(curr.child);
                curr.next = curr.child;
                curr.child.prev = curr;
                curr.child = null;

                if (next != null) {
                    childTail.next = next;
                    next.prev = childTail;
                }
                last = childTail;
            } else {
                last = curr;
            }
            curr = next;
        }
        return last;
    }

    public static void main(String[] args) {
        MultiNode n1 = new MultiNode(1);
        MultiNode n2 = new MultiNode(2);
        MultiNode n3 = new MultiNode(3);
        MultiNode n4 = new MultiNode(4);

        n1.next = n2; n2.prev = n1;
        n2.next = n3; n3.prev = n2;
        n2.child = n4;

        FlattenAMultilevelDoublyLinkedList solver = new FlattenAMultilevelDoublyLinkedList();
        MultiNode head = solver.flatten(n1);

        System.out.print("Flattened List: ");
        MultiNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + (curr.next != null ? " <-> " : ""));
            curr = curr.next;
        }
        System.out.println();
    }
}