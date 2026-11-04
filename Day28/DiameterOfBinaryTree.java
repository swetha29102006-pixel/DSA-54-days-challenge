/**
 * LeetCode 543: Diameter of Binary Tree
 * Return the length of the diameter of the tree (longest path between any two nodes).
 * Time Complexity: O(N) visiting every node once.
 * Space Complexity: O(H) where H is tree height for recursive stack.
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

public class DiameterOfBinaryTree {
    // Calculates diameter (longest path between any two nodes) using bottom-up depth DFS
    private int maxDiameter;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDiameter = 0;
        maxDepth(root);
        return maxDiameter;
    }

    private int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = maxDepth(node.left);
        int right = maxDepth(node.right);
        maxDiameter = Math.max(maxDiameter, left + right);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2, new TreeNode(4), new TreeNode(5));
        root.right = new TreeNode(3);

        DiameterOfBinaryTree solver = new DiameterOfBinaryTree();
        System.out.println("Diameter: " + solver.diameterOfBinaryTree(root)); // 3
    }
}