class Solution {
    public int minCost(int n, int[][] edges) {
        //edges[i] = u,v,w
        int sum = 0;
        boolean[] vis = new boolean[n];
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int[] e : edges){
            adj.get(e[0]).add(new int[]{e[1], e[2]});
            adj.get(e[1]).add(new int[]{e[0], 2*e[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        pq.offer(new int[]{0,0});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int node = curr[0];
            int dis = curr[1];

            if(dis > dist[node]) continue;
            if(node == n-1) return dis;

            for(int[] it : adj.get(node)){
                int newnode = it[0];
                int newdis = dis + it[1];
                if(newdis < dist[newnode]){
                    pq.offer(new int[]{newnode, newdis});
                    dist[newnode] = newdis;
                }
            }
        }
        return -1;
    }
}