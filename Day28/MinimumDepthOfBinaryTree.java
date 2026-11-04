/**
 * LeetCode 111: Minimum Depth of Binary Tree
 * Find the minimum depth of a binary tree (number of nodes along shortest path from root to nearest leaf).
 * Time Complexity: O(N) visiting nodes up to the closest leaf.
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

public class MinimumDepthOfBinaryTree {
    // Calculates minimum depth from root node to the nearest leaf node
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));

        MinimumDepthOfBinaryTree solver = new MinimumDepthOfBinaryTree();
        System.out.println("Minimum Depth: " + solver.minDepth(root)); // 2
    }
}