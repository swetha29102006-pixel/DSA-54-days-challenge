// LeetCode 104: Maximum Depth of Binary Tree

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

public class MaximumDepthOfBinaryTree {
    /**
     * Calculates the maximum depth of a binary tree using recursive DFS.
     * Time Complexity: O(N) - visits each node exactly once.
     * Space Complexity: O(H) - call stack proportional to tree height H.
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        // Constructing sample tree: [3, 9, 20, null, null, 15, 7]
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        MaximumDepthOfBinaryTree solution = new MaximumDepthOfBinaryTree();
        System.out.println("Max Depth: " + solution.maxDepth(root)); // Expected output: 3
    }
}