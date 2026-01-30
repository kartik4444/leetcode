/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lca(root, p, q);
    }

    private TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        // if either left or right node is null means return null
        if (root == null)
            return null;

        if (root.val == p.val)
            return root;

        if (root.val == q.val)
            return root;

        // find lca from left subtree
        TreeNode leftlca = lca(root.left, p, q);

        //find lca from right subtree
        TreeNode rightlca = lca(root.right, p, q);
         
         //if both non-null means current root is LCA 
        if (leftlca != null && rightlca != null) {
            return root;
        } else if (rightlca == null)   //if null from right subtree means find lca in leftsubtree
            return lca(leftlca, p, q);
        else
            return lca(rightlca, p, q); //if null from left subtree means find lca in rightsubtree
    }
}