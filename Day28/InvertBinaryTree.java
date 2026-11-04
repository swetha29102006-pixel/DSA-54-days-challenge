/**
 * LeetCode 226: Invert Binary Tree
 * Given the root of a binary tree, invert the tree, and return its root.
 * Time Complexity: O(N) visiting each node once.
 * Space Complexity: O(H) where H is tree height for recursive call stack.
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

public class InvertBinaryTree {
    // Recursively inverts/mirrors a binary tree by swapping left and right subtrees
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode leftInverted = invertTree(root.left);
        TreeNode rightInverted = invertTree(root.right);

        root.left = rightInverted;
        root.right = leftInverted;
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        root.right = new TreeNode(7, new TreeNode(6), new TreeNode(9));

        InvertBinaryTree solver = new InvertBinaryTree();
        TreeNode inverted = solver.invertTree(root);
        System.out.println("Root left child after inversion: " + inverted.left.val);   // 7
        System.out.println("Root right child after inversion: " + inverted.right.val); // 2
    }
}