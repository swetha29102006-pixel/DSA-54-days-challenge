import java.util.ArrayList;
import java.util.List;

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

class CoordinatePoint {
    int row, col, val;
    CoordinatePoint(int row, int col, int val) {
        this.row = row;
        this.col = col;
        this.val = val;
    }
}

public class VerticalOrderTraversalOfABinaryTree {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<CoordinatePoint> points = new ArrayList<>();
        dfs(root, 0, 0, points);
        return result;
    }

    private void dfs(TreeNode node, int row, int col, List<CoordinatePoint> points) {
        if (node == null) return;
        points.add(new CoordinatePoint(row, col, node.val));
        dfs(node.left, row + 1, col - 1, points);
        dfs(node.right, row + 1, col + 1, points);
    }
}