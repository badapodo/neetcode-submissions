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
    public int maxDepth(TreeNode root) {
        return search(root);
    }

    public int search(TreeNode curr) {
        if (curr == null) return 0;
        int left = 1;
        int right = 1;
        if (curr.left != null) left += search(curr.left);
        if (curr.right != null) right += search(curr.right);
        return Math.max(left, right);
    }
}
