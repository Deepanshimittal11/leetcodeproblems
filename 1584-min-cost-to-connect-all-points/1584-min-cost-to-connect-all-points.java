class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int edges = 0;
        boolean[] vis = new boolean[n]; 

        int sum = 0;
        // int totalcost = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));
        pq.offer(new int[]{0,0}); //here int[][0] = min dist & int[][1] = node;

        while(edges < n){
            int[] curr = pq.poll();
            int cost = curr[0];
            int currNode = curr[1];
            if(vis[currNode]) continue;
            sum += cost;            

            vis[currNode] = true;
            for(int i=0;i<n;i++){
                if(!vis[i]){
                    int dist = Math.abs(points[i][0] - points[currNode][0]) + Math.abs(points[i][1] - points[currNode][1]);
                    pq.offer(new int[]{dist,i});
                }
            }
            edges++;
        }

        return sum;
    }
}