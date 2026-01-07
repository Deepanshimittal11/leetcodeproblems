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
    long totalsum;
    long maxPdt;
    static final int inf = 1000000007;
    public int maxProduct(TreeNode root) {
        maxPdt = Integer.MIN_VALUE;
        totalsum = calculateSum(root);

        dfs(root);
        
        return (int) (maxPdt % inf);
    }

    public long dfs(TreeNode root){
        if(root == null) return 0;

        long left = dfs(root.left);
        long right = dfs(root.right);
        long subtree = left + right + root.val;
        
        long pdt = subtree * (totalsum - subtree);
        maxPdt = Math.max(maxPdt, pdt);
        return subtree;
    }

    public int calculateSum(TreeNode root){
        if(root == null) return 0;
        return root.val + calculateSum(root.left) + calculateSum(root.right);
    }
}