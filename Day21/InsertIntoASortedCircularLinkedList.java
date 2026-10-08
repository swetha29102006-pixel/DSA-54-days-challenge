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
    public CircularNode insert(CircularNode head, int insertVal) {
        if (head == null) {
            CircularNode newNode = new CircularNode(insertVal);
            newNode.next = newNode;
            return newNode;
        }

        CircularNode prev = head;
        CircularNode curr = head.next;
        return head;
    }
}