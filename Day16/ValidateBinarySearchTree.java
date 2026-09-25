// LeetCode 98: Validate Binary Search Tree

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

public class ValidateBinarySearchTree {
    /**
     * Validates if a binary tree satisfies the BST property using range-bounded DFS.
     * Time Complexity: O(N) - visits each node once.
     * Space Complexity: O(H) - recursion stack bounded by height H.
     */
    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    private boolean validate(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }
        if (min != null && node.val <= min) {
            return false;
        }
        if (max != null && node.val >= max) {
            return false;
        }
        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        ValidateBinarySearchTree solution = new ValidateBinarySearchTree();
        System.out.println("Is Valid BST: " + solution.isValidBST(root)); // Output: true
    }
}