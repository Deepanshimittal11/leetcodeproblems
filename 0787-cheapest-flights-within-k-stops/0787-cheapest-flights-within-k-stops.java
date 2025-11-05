class Solution {
    class pair{
        int cost;
        int node;
        int steps;
        pair(int cost, int node, int steps){
            this.cost = cost;
            this.node = node;
            this.steps = steps;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] f : flights){
            adj.get(f[0]).add(new int[]{f[1],f[2]});
        }
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Queue<pair> q = new LinkedList<>();
        dist[src] = 0;
        q.offer(new pair(0,src,0));
        while(!q.isEmpty()){
            pair p =q.poll();
            int cost = p.cost, step = p.steps, node = p.node;
            if(step>k) continue;
            for(int[] it : adj.get(node)){
                int curr = it[0], price = it[1];
                int newcost = cost + price;
                if(newcost < dist[curr] && step<=k){
                    dist[curr] = newcost;
                    q.offer(new pair(newcost, curr, step+1));
                }
            }
        }
        if(dist[dst]==Integer.MAX_VALUE) return -1;
        return dist[dst];
    }
}