import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LeetCode 107: Binary Tree Level Order Traversal II
 * Given root of a binary tree, return the bottom-up level order traversal of its nodes' values.
 * Time Complexity: O(N) where N is number of nodes in tree.
 * Space Complexity: O(N) for BFS queue and resulting level lists.
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

public class BinaryTreeLevelOrderTraversalII {
    // Bottom-up level order traversal returning level lists from bottom leaves up to root
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                currentLevel.add(node.val);

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            result.addFirst(currentLevel);
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));

        BinaryTreeLevelOrderTraversalII solver = new BinaryTreeLevelOrderTraversalII();
        List<List<Integer>> result = solver.levelOrderBottom(root);
        System.out.println("Bottom-Up Level Order: " + result); // [[15, 7], [9, 20], [3]]
    }
}