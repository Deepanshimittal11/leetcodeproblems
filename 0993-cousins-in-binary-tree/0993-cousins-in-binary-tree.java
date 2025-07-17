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
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            boolean xi = false;
            boolean yi = false;
            TreeNode xp = null;
            TreeNode yp = null;
            
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();               

                if(node.left != null){
                    queue.offer(node.left);
                    if(node.left.val==x){
                        xi = true;
                        xp = node;
                    }
                    if(node.left.val==y){
                        yi = true;
                        yp = node;
                    }
                }
                if(node.right != null){
                    queue.offer(node.right);
                    if(node.right.val==x){
                        xi = true;
                        xp = node;
                    }
                    if(node.right.val==y){
                        yi = true;
                        yp = node;
                    }
                }
            }
            if(xi && yi){
                return xp != yp;
            }
            if(xi || yi){
                return false;
            }
        }
        return false;
    }
}