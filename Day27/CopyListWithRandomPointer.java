import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyListWithRandomPointer {
    // Deep copies a linked list with random pointers using node-to-clone hash table
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Map<Node, Node> map = new HashMap<>();

        Node curr = head;
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        curr = head;
        while (curr != null) {
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }

        return map.get(head);
    }

    public static void main(String[] args) {
        Node n1 = new Node(7);
        Node n2 = new Node(13);
        Node n3 = new Node(11);
        n1.next = n2; n2.next = n3;
        n2.random = n1; n3.random = n2;

        CopyListWithRandomPointer solver = new CopyListWithRandomPointer();
        Node clonedHead = solver.copyRandomList(n1);
        System.out.println("Original head val: " + n1.val + ", Cloned head val: " + clonedHead.val);
        System.out.println("Cloned node2 random val: " + clonedHead.next.random.val); // 7
    }
}