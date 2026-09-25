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
    public boolean isSymmetric(TreeNode root) {
        return true;
    }
}