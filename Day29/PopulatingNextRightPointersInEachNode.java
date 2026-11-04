/**
 * LeetCode 116: Populating Next Right Pointers in Each Node
 * Populate each next pointer to point to its next right node in a perfect binary tree.
 * Time Complexity: O(N) where N is number of nodes.
 * Space Complexity: O(1) auxiliary memory.
 */
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    public Node(int _val) {
        val = _val;
    }
    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

public class PopulatingNextRightPointersInEachNode {
    // Connects each node's next pointer to its right sibling using O(1) extra space level order traversal
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Node leftmost = root;
        while (leftmost.left != null) {
            Node head = leftmost;
            while (head != null) {
                head.left.next = head.right;
                if (head.next != null) {
                    head.right.next = head.next.left;
                }
                head = head.next;
            }
            leftmost = leftmost.left;
        }

        return root;
    }

    public static void main(String[] args) {
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n2 = new Node(2, n4, n5, null);
        Node n3 = new Node(3, n6, n7, null);
        Node root = new Node(1, n2, n3, null);

        PopulatingNextRightPointersInEachNode solver = new PopulatingNextRightPointersInEachNode();
        solver.connect(root);

        System.out.println("n2 next: " + (n2.next != null ? n2.next.val : "null")); // 3
        System.out.println("n5 next: " + (n5.next != null ? n5.next.val : "null")); // 6
    }
}