/**
 * LeetCode 110: Balanced Binary Tree
 * Given a binary tree, determine if it is height-balanced.
 * Time Complexity: O(N) each node is checked once bottom-up.
 * Space Complexity: O(H) where H is tree height for recursion stack.
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

public class BalancedBinaryTree {
    // Verifies height-balanced binary tree in O(N) time with bottom-up height verification
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return checkHeight(root) != -1;
    }

    private int checkHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = checkHeight(node.left);
        if (left == -1) return -1;

        int right = checkHeight(node.right);
        if (right == -1) return -1;

        if (Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode balanced = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        TreeNode unbalanced = new TreeNode(1, new TreeNode(2, new TreeNode(3, new TreeNode(4), null), null), null);

        BalancedBinaryTree solver = new BalancedBinaryTree();
        System.out.println("Tree 1 is balanced: " + solver.isBalanced(balanced));     // true
        System.out.println("Tree 2 is balanced: " + solver.isBalanced(unbalanced));   // false
    }
}