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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        search(root, ret, 0);
        return ret;
    }

    private void search(TreeNode curr, List<Integer> lst, int depth) {
        if (curr == null) return;
        if (lst.size() <= depth) lst.add(curr.val);
        else lst.set(depth, curr.val);
        search(curr.left, lst, depth + 1);
        search(curr.right, lst, depth + 1);
    }
}
