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
    // public TreeNode searchBST(TreeNode root, int val1) {
    //     if(root==null || root.val == val1) return root;

    //     if(root.val>val1) return searchBST(root.left, val1);
    //     else return searchBST(root.right, val1);
    // }

    public TreeNode searchBST(TreeNode root, int val1) {
        while(root != null){
            if(root.val == val1) return root;
            else if(root.val < val1) root = root.right;
            else root = root.left;
        }
        return null;
    }
}