// LeetCode 101: Symmetric Tree

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

public class SymmetricTree {
    /**
     * Checks if a binary tree is symmetric around its center.
     * Time Complexity: O(N) - visits each node pair once.
     * Space Complexity: O(H) - recursion stack bound by tree height H.
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        return (t1.val == t2.val) 
            && isMirror(t1.left, t2.right) 
            && isMirror(t1.right, t2.left);
    }

    public static void main(String[] args) {
        // Symmetric tree test: [1, 2, 2, 3, 4, 4, 3]
        TreeNode root = new TreeNode(1,
            new TreeNode(2, new TreeNode(3), new TreeNode(4)),
            new TreeNode(2, new TreeNode(4), new TreeNode(3))
        );
        SymmetricTree solution = new SymmetricTree();
        System.out.println("Is Symmetric: " + solution.isSymmetric(root)); // Expected: true
    }
}