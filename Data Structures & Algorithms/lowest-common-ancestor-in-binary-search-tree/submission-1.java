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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return search(root, p, q);
    }

    private TreeNode search(TreeNode curr, TreeNode p, TreeNode q) {
        if (curr.val > p.val && curr.val > q.val) return search(curr.left, p, q);
        if (curr.val < p.val && curr.val < q.val) return search(curr.right, p, q);
        return curr;
    }
}
