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

//math.abs(left-right)>1 //not balanced
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;

        int lefth = height(root.left);
        int righth = height(root.right);
        if(Math.abs(lefth - righth) > 1) return false;

        return isBalanced(root.left) && isBalanced(root.right);
    }
    public int height(TreeNode root){
        if(root==null) return 0;

        int left = height(root.left);
        int right = height(root.right);

        return 1 + Math.max(left, right);
    }
}