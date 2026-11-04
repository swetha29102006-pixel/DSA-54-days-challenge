import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode 145: Binary Tree Postorder Traversal
 * Given the root of a binary tree, return the postorder traversal of its nodes' values.
 * Time Complexity: O(N) single pass visiting every tree node.
 * Space Complexity: O(H) for tree height in stack.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BinaryTreePostorderTraversal {
    // Postorder traversal (Left -> Right -> Root) using modified preorder and front insertion
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            result.addFirst(curr.val);
            if (curr.left != null) {
                stack.push(curr.left);
            }
            if (curr.right != null) {
                stack.push(curr.right);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        BinaryTreePostorderTraversal solver = new BinaryTreePostorderTraversal();
        List<Integer> traversal = solver.postorderTraversal(root);
        System.out.println("Postorder Traversal: " + traversal); // [3, 2, 1]
    }
}