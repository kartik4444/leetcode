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
    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }

    private boolean isValid(TreeNode root, Integer left, Integer right) {
        if (root == null)
            return true;

        if (left != null && left >= root.val)
            return false;
        if (right != null && right <= root.val)
            return false;

        return isValid(root.left, left, root.val) && isValid(root.right, root.val, right);
    }
}