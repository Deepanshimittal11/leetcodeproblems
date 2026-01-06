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
    public int maxLevelSum(TreeNode root) {
        int maxSum = Integer.MIN_VALUE;
        int level = 1, ansLevel = 1;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();
            int sum = 0;

            for(int i=0;i<size;i++){
                TreeNode currentNode = q.poll();
                sum += currentNode.val;

                if(currentNode.left != null){
                    q.offer(currentNode.left);
                }
                if(currentNode.right != null){
                    q.offer(currentNode.right);
                }
            }

            if(sum > maxSum){
                maxSum = sum;
                ansLevel = level;
            }
            level++;
        }
        return ansLevel;
    }
}