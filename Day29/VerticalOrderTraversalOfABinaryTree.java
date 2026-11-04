import java.util.ArrayList;
import java.util.Collections;
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
    // 2D coordinate vertical order traversal sorted by col, row, and val
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<CoordinatePoint> points = new ArrayList<>();
        dfs(root, 0, 0, points);

        Collections.sort(points, (a, b) -> {
            if (a.col != b.col) return Integer.compare(a.col, b.col);
            if (a.row != b.row) return Integer.compare(a.row, b.row);
            return Integer.compare(a.val, b.val);
        });

        int prevCol = Integer.MIN_VALUE;
        for (CoordinatePoint p : points) {
            if (p.col != prevCol) {
                result.add(new ArrayList<>());
                prevCol = p.col;
            }
            result.get(result.size() - 1).add(p.val);
        }

        return result;
    }

    private void dfs(TreeNode node, int row, int col, List<CoordinatePoint> points) {
        if (node == null) return;
        points.add(new CoordinatePoint(row, col, node.val));
        dfs(node.left, row + 1, col - 1, points);
        dfs(node.right, row + 1, col + 1, points);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));

        VerticalOrderTraversalOfABinaryTree solver = new VerticalOrderTraversalOfABinaryTree();
        List<List<Integer>> vertical = solver.verticalTraversal(root);
        System.out.println("Vertical Traversal: " + vertical); // [[9], [3, 15], [20], [7]]
    }
}