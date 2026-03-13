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
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null) return 0;

        return cntpath(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }
    public int cntpath(TreeNode root, long total){
        if(root==null) return 0;

        int cnt = 0;

        if(root.val == total) cnt++;

        cnt += cntpath(root.left, total-root.val);
        cnt += cntpath(root.right, total-root.val);

        return cnt;
    }
}