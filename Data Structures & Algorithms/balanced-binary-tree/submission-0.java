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
    boolean ret = true;

    public boolean isBalanced(TreeNode root) {
        search(root);
        return ret;
    }

    private int search(TreeNode curr) {
        if (curr == null) return 0;
        int left = search(curr.left);
        int right = search(curr.right);

        if (Math.abs(left - right) > 1) ret = false;
        return Math.max(left, right) + 1;
    }
}
