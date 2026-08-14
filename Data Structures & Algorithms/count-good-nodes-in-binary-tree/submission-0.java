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
    public int goodNodes(TreeNode root) {
        return search(root, -101);
    }

    private int search(TreeNode curr, int max) {
        if (curr == null) return 0;
        if (curr.val >= max) {
            return search(curr.left, curr.val) + search(curr.right, curr.val) + 1;
        }
        return search(curr.left, max) + search(curr.right, max);
    }
}
