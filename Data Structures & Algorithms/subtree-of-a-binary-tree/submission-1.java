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
    boolean ret = false;

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        isSub(root, subRoot);
        return ret;
    }

    private void isSub(TreeNode root, TreeNode subRoot) {
        if (ret) return ;
        if (root == null) return;
        ret = doSearch(root, subRoot);
        isSub(root.left, subRoot);
        isSub(root.right, subRoot);
    }
    private boolean doSearch(TreeNode curr, TreeNode sub) {
        if (curr == null && sub == null) return true;
        if (curr == null || sub == null) return false;
        if (curr.val == sub.val) return (doSearch(curr.left, sub.left) && doSearch(curr.right, sub.right));
        return false;
    }
}
