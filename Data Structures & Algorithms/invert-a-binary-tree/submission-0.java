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
    public TreeNode invertTree(TreeNode root) {
        doInvert(root);
        return root;
    }

    private void doInvert(TreeNode curr) {
        if (curr == null) return;
        TreeNode tmp = curr.left;
        curr.left = curr.right;
        curr.right = tmp;
        if (curr.left != null) doInvert(curr.left);
        if (curr.right != null) doInvert(curr.right);
    }
}
