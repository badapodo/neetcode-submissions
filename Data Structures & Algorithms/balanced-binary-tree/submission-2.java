/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isBalanced(TreeNode root) {
        return depth(root) != -1;
    }

    public int depth(TreeNode curr) {
        int left = 0;
        int right = 0;
        if (curr == null) return 0;
        if (curr.left != null) {
            left = depth(curr.left);
        }
        if (curr.right != null) {
            right = depth(curr.right);
        }
        if (left == -1 || right == -1) return -1;
        if (Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }
}
