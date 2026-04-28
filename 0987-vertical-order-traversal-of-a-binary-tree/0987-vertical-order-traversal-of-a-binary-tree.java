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
class Tuple{
    TreeNode node;
    int row, col;
    public Tuple(TreeNode node, int row, int col){
        this.node = node;
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> mpp = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<Tuple>();
        q.offer(new Tuple(root, 0, 0));

        while(!q.isEmpty()){
            // int size = q.size();
            Tuple tuple = q.poll();
            TreeNode node = tuple.node;
            int x = tuple.row;
            int y = tuple.col;
            if(!mpp.containsKey(x)){
                mpp.put(x, new TreeMap<>());
            }
            if(!mpp.get(x).containsKey(y)){
                mpp.get(x).put(y, new PriorityQueue<>());
            }
            mpp.get(x).get(y).offer(node.val);

            if(node.left != null){
                q.offer(new Tuple(node.left, x-1, y+1));
            }
            if(node.right != null){
                q.offer(new Tuple(node.right, x+1, y+1));
            }
        }
        for(TreeMap<Integer, PriorityQueue<Integer>> tm : mpp.values()){
            ans.add(new ArrayList<>());
            for(PriorityQueue<Integer> pq : tm.values()){
                while(!pq.isEmpty()){
                    System.out.print(pq.peek());
                    ans.get(ans.size()-1).add(pq.poll());
                }
            }
        }
        return ans;
    }
}