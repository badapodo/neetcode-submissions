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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return search(p, q);
    }

    private boolean search(TreeNode n, TreeNode q) {
        if (n == null && q == null) return true;
        if (n == null || q == null) return false;
        if (n.val != q.val) return false;
        if (search(n.left, q.left) && search(n.right, q.right)) return true;
        return false;
    }
}
