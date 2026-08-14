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
    int index = 1;
    int ret = -1;
    public int kthSmallest(TreeNode root, int k) {
        search(root, k);
        return ret;
    }

    private void search(TreeNode curr, int target) {
        if (curr == null) return;
        search(curr.left, target);
        if (index == target) {
            ret = curr.val;
        }
        if (index > target) return;
        index++;
        search(curr.right, target);
    }
}
