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
    int preIndex;
    Map<Integer, Integer> map;  // 키: value, 값: 인덱스
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        preIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1);
    }

    public TreeNode build(int[] preorder, int left, int right) {
        if (left > right) return null;
        int v = preorder[preIndex++];
        int index = map.get(v);

        TreeNode curr = new TreeNode(v);
        curr.left = build(preorder, left, index - 1);
        curr.right = build(preorder, index + 1, right);
        return curr;
    }
}
