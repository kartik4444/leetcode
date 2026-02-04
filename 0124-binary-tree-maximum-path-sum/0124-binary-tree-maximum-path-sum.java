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
    private int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root) {
        if (root == null)
            return 0;

        int leftmax = Math.max(dfs(root.left),0);
        int rightmax = Math.max(dfs(root.right),0);

        //calculate sum with split , means path including this node
        res = Math.max(res, root.val + leftmax + rightmax);

        //return max sum without split path
        return root.val + Math.max(leftmax, rightmax);
    }
}