/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {

    enum Direction {
        LEFT,
        RIGHT
    }

    static int getHeight(TreeNode node, Direction direction) {
        int ht = 0;
        while (node != null) {
            ht++;
            node = direction == Direction.LEFT ? node.left : node.right;
        }

        return ht;
    }

    public int countNodes(TreeNode root) {
        if (root == null) // Base case
            return 0;

        int leftHeight = getHeight(root, Direction.LEFT);
        int rightHeight = getHeight(root, Direction.RIGHT);

        if (leftHeight == rightHeight)
            return (1 << leftHeight) - 1; // 2^leftHeight - 1

        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}