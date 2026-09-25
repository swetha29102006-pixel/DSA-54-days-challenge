// LeetCode 230: Kth Smallest Element in a BST

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

public class KthSmallestElementInABST {
    private int count = 0;
    private int result = 0;

    public int kthSmallest(TreeNode root, int k) {
        this.count = 0;
        this.result = 0;
        return result;
    }
}