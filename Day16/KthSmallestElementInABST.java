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

    /**
     * Finds the kth smallest element in a BST using early-stopping inorder traversal.
     * Time Complexity: O(H + k) - stops as soon as kth element is reached.
     * Space Complexity: O(H) - recursion stack bounded by tree height H.
     */
    public int kthSmallest(TreeNode root, int k) {
        this.count = 0;
        this.result = 0;
        inorder(root, k);
        return result;
    }

    private void inorder(TreeNode node, int k) {
        if (node == null || count >= k) {
            return;
        }
        inorder(node.left, k);
        count++;
        if (count == k) {
            result = node.val;
            return;
        }
        inorder(node.right, k);
    }

    public static void main(String[] args) {
        // BST: [3, 1, 4, null, 2]
        TreeNode root = new TreeNode(3,
            new TreeNode(1, null, new TreeNode(2)),
            new TreeNode(4)
        );
        KthSmallestElementInABST solution = new KthSmallestElementInABST();
        System.out.println("1st Smallest: " + solution.kthSmallest(root, 1)); // Output: 1
    }
}