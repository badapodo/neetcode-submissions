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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        search(root, 0, ret);
        return ret;
    }

    public void search(TreeNode curr, int depth, List<List<Integer>> map) {
        if (curr == null) return;
        if (map.size() <= depth) map.add(new ArrayList<>());
        map.get(depth).add(curr.val);
        search(curr.left, depth + 1, map);
        search(curr.right, depth + 1, map);
    }
}
