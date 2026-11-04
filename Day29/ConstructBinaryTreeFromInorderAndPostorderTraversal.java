import java.util.HashMap;
import java.util.Map;

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

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    // Reconstructs binary tree from inorder and postorder sequences using root-from-end logic
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return build(inorder, 0, inorder.length - 1,
                     postorder, 0, postorder.length - 1, inMap);
    }

    private TreeNode build(int[] inorder, int inStart, int inEnd,
                           int[] postorder, int postStart, int postEnd,
                           Map<Integer, Integer> inMap) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postEnd]);
        int inRoot = inMap.get(root.val);
        int numsLeft = inRoot - inStart;

        root.left = build(inorder, inStart, inRoot - 1,
                          postorder, postStart, postStart + numsLeft - 1, inMap);
        root.right = build(inorder, inRoot + 1, inEnd,
                           postorder, postStart + numsLeft, postEnd - 1, inMap);

        return root;
    }

    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        ConstructBinaryTreeFromInorderAndPostorderTraversal solver = new ConstructBinaryTreeFromInorderAndPostorderTraversal();
        TreeNode root = solver.buildTree(inorder, postorder);
        System.out.println("Reconstructed Root: " + root.val); // 3
        System.out.println("Left Child: " + root.left.val);     // 9
        System.out.println("Right Child: " + root.right.val);   // 20
    }
}