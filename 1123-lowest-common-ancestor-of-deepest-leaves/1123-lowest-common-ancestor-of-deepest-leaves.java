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
    Map<TreeNode, Integer> mpp = new HashMap<>();
    int maxD = 0;

    public void depth(TreeNode root, int d){
        if(root == null) return;

        maxD = Math.max(maxD, d);
        mpp.put(root, d);

        depth(root.left, d+1);
        depth(root.right, d+1);
    }

    public TreeNode lca(TreeNode root){
        if(root==null) return null;
        if(mpp.get(root)==maxD){
            return root;
        }

        TreeNode l = lca(root.left);
        TreeNode r = lca(root.right);

        if(l!=null && r!=null) return root;

        return l != null ? l : r;
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        depth(root, 0);
        return lca(root);
    }
}