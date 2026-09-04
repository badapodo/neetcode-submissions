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
    int count = 0;
    int val;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return val;
    }

    public boolean inorder(TreeNode curr, int k) {
        if (curr == null) return false;

        if (inorder(curr.left, k)) {
            return true;
        }

        count++;
        
        if (count == k) {
            val = curr.val;
            return true;
        }

        return inorder(curr.right, k);
    }
}
