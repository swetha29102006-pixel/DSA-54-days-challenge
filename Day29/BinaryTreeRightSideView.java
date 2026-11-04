import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

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

public class BinaryTreeRightSideView {
    // Collects rightmost node value of each level using BFS level order traversal
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> visibleValues = new ArrayList<>();
        if (root == null) {
            return visibleValues;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = queue.poll();
                if (i == levelSize - 1) {
                    visibleValues.add(curr.val);
                }
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
        }

        return visibleValues;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2, null, new TreeNode(5));
        root.right = new TreeNode(3, null, new TreeNode(4));

        BinaryTreeRightSideView solver = new BinaryTreeRightSideView();
        List<Integer> view = solver.rightSideView(root);
        System.out.println("Right Side View: " + view); // [1, 3, 4]
    }
}