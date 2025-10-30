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
    int postInd;
    public Map<Integer, Integer> mpp = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i=0;i<inorder.length;i++){
            mpp.put(inorder[i],i);
        }
        postInd = postorder.length-1;
        return helper(inorder, postorder,0,inorder.length-1);
    }
    public TreeNode helper(int[] inorder,int[] postorder, int start, int end){
        if(start>end) return null;
        int rootval = postorder[postInd--];
        TreeNode root = new TreeNode(rootval);
        int inInd = mpp.get(rootval);
        root.right = helper(inorder, postorder, inInd+1, end);
        root.left = helper(inorder, postorder, start, inInd-1);
        return root;
    }
}