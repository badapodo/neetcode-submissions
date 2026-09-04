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
    int max = -1000;
    public int maxPathSum(TreeNode root) {
        search(root);
        return max;
    }

    private int search(TreeNode curr) {
        if (curr == null) return 0;
        int left = Math.max(0, search(curr.left));
        int right = Math.max(0, search(curr.right));
        max = Math.max(max, left + curr.val + right);

        return curr.val + Math.max(left, right);
    }
}
