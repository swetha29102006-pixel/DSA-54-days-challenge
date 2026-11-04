import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * LeetCode 144: Binary Tree Preorder Traversal
 * Given the root of a binary tree, return the preorder traversal of its nodes' values.
 * Time Complexity: O(N) where N is number of nodes in binary tree.
 * Space Complexity: O(H) where H is tree height for call stack / deque.
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

public class BinaryTreePreorderTraversal {
    // Iterative preorder traversal (Root -> Left -> Right) using a LIFO stack
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            result.add(curr.val);
            if (curr.right != null) {
                stack.push(curr.right);
            }
            if (curr.left != null) {
                stack.push(curr.left);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        BinaryTreePreorderTraversal solver = new BinaryTreePreorderTraversal();
        List<Integer> traversal = solver.preorderTraversal(root);
        System.out.println("Preorder Traversal: " + traversal); // [1, 2, 3]
    }
}