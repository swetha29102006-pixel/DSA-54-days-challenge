class CircularNode {
    public int val;
    public CircularNode next;

    public CircularNode() {}
    public CircularNode(int val) {
        this.val = val;
    }
    public CircularNode(int val, CircularNode next) {
        this.val = val;
        this.next = next;
    }
}

public class InsertIntoASortedCircularLinkedList {
    // Inserts a node into a sorted circular linked list maintaining sorted order
    public CircularNode insert(CircularNode head, int insertVal) {
        if (head == null) {
            CircularNode newNode = new CircularNode(insertVal);
            newNode.next = newNode;
            return newNode;
        }

        CircularNode prev = head;
        CircularNode curr = head.next;
        boolean toInsert = false;

        do {
            if (prev.val <= insertVal && insertVal <= curr.val) {
                toInsert = true;
            } else if (prev.val > curr.val) {
                if (insertVal >= prev.val || insertVal <= curr.val) {
                    toInsert = true;
                }
            }

            if (toInsert) {
                prev.next = new CircularNode(insertVal, curr);
                return head;
            }

            prev = curr;
            curr = curr.next;
        } while (prev != head);

        prev.next = new CircularNode(insertVal, curr);
        return head;
    }

    public static void main(String[] args) {
        CircularNode n1 = new CircularNode(3);
        CircularNode n2 = new CircularNode(4);
        CircularNode n3 = new CircularNode(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n1;

        InsertIntoASortedCircularLinkedList solver = new InsertIntoASortedCircularLinkedList();
        CircularNode head = solver.insert(n1, 2);

        System.out.print("Circular List: ");
        CircularNode curr = head;
        if (curr != null) {
            do {
                System.out.print(curr.val + " -> ");
                curr = curr.next;
            } while (curr != head);
            System.out.println("(" + curr.val + ")");
        }
    }
}