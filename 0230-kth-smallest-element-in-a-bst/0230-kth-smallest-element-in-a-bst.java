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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> res = new ArrayList<>();
        inorder(root,res);
        return res.get(k-1);
    }

    private TreeNode inorder(TreeNode root, List<Integer> res) {
        if (root == null)
            return null;

        TreeNode lnode = inorder(root.left, res);   
        res.add(root.val);
        TreeNode rnode = inorder(root.right, res);

        return root;
    }
}