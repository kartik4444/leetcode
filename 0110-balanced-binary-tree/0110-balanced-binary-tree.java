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
    public boolean isBalanced(TreeNode root) {
       
         if(isHeightBalanced(root) == -1 )return false;
         else return true;
    }

    private int isHeightBalanced(TreeNode root){
        if(root==null) return 0; //child of a leaf node

        int leftheight = isHeightBalanced(root.left);
        int rightheight = isHeightBalanced(root.right);

        //early check 
        if(leftheight == -1 || rightheight == -1) return -1;

        //check if it is unbalanced
        if(Math.abs(leftheight-rightheight)>1) return -1; //found unbalanced

        //otherwise return the height
        return 1 + Math.max(leftheight,rightheight);

    }
}