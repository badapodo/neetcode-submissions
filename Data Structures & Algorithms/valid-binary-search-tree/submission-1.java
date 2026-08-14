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
    int max = 1000000000;
    public boolean isValidBST(TreeNode root) { 
        search(root, -1 * max, max);
        return ret;
    }

    public void search(TreeNode root, int min, int max) {
        if (root == null) return;
        if (!ret) return;
        if (!(root.val > min && root.val < max)) {
            ret = false;
            return;
        }
        search(root.left, min, root.val);
        search(root.right, root.val, max);
    }
}
