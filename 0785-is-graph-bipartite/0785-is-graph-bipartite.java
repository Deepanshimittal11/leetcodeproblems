// class Node{
//     int node, color;
//     Node(int node, int color){
//         this.node = node;
//         this.color = color;
//     }
// }
class Solution {
    public boolean isBipartite(int[][] graph) {
        int v = graph.length;
        
        int[] vis = new int[v];
        for(int i=0;i<v;i++){
            vis[i] = -1; //initially each node is covered with -1.
        }

        for(int i=0;i<v;i++){
            if(vis[i]==-1){
                if(bfs(graph, vis, i, v) == false) return false;
            }
        }
        return true;
    }
    public boolean bfs(int[][] graph, int[] vis, int i, int v){
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);
        vis[i] = 0; //first node is coloured with 0.

        while(!q.isEmpty()){
            int node = q.poll();
            for(int adj : graph[node]){
                if(vis[adj]==-1){
                    vis[adj] = 1 - vis[node];
                    q.offer(adj);
                }
                else if(vis[adj] == vis[node]) return false;
            }
        }
        return true;
    }
}