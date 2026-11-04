/**
 * LeetCode 100: Same Tree
 * Given roots of two binary trees p and q, return true if they are structurally identical and nodes have same value.
 * Time Complexity: O(min(N, M)) where N and M are nodes in p and q.
 * Space Complexity: O(min(H1, H2)) recursion stack depth.
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

public class SameTree {
    // Recursively verifies structural and value equality between two binary trees
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode t2 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode t3 = new TreeNode(1, new TreeNode(2), null);

        SameTree solver = new SameTree();
        System.out.println("t1 and t2 are same: " + solver.isSameTree(t1, t2)); // true
        System.out.println("t1 and t3 are same: " + solver.isSameTree(t1, t3)); // false
    }
}