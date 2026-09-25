// LeetCode 94: Binary Tree Inorder Traversal
import java.util.ArrayList;
import java.util.List;

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

public class InorderTraversal {
    /**
     * Performs an inorder traversal (Left -> Root -> Right) of a binary tree.
     * Time Complexity: O(N) - visits every node once.
     * Space Complexity: O(H) - call stack proportional to tree height H.
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        helper(root, result);
        return result;
    }

    private void helper(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        helper(node.left, result);
        result.add(node.val);
        helper(node.right, result);
    }

    public static void main(String[] args) {
        // Tree: 1 -> right: 2 -> left: 3
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        InorderTraversal solution = new InorderTraversal();
        System.out.println("Inorder Traversal: " + solution.inorderTraversal(root)); // Output: [1, 3, 2]
    }
}