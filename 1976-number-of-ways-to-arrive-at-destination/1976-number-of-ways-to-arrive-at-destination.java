class Solution {
    public int countPaths(int n, int[][] roads) {
        final int MOD = 1000000007;

        List<List<int[]>> graph = new ArrayList<>();
        for(int i=0;i<n;i++) graph.add(new ArrayList<>());

        for(int[] r : roads){
            graph.get(r[0]).add(new int[]{r[1],r[2]});
            graph.get(r[1]).add(new int[]{r[0],r[2]});
        }

        long[] dist = new long[n];
        long[] ways = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0]=0;
        ways[0]=1;

        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b) -> Long.compare(a[0],b[0]));
        pq.offer(new long[]{0,0});

        while(!pq.isEmpty()){
            long[] curr = pq.poll();
            long d = curr[0];
            int node = (int) curr[1];
            if(d > dist[node]) continue;

            for(int[] edge : graph.get(node)){
                int v = edge[0];
                long wt = edge[1];
                if(d+wt < dist[v]){
                    dist[v] = d+wt;
                    ways[v] = ways[node];
                    pq.offer(new long[]{dist[v],v});
                }
                else if(d+wt == dist[v]){
                    ways[v] = (ways[v]+ways[node])%MOD;
                }
            }
        }
        return (int) (ways[n-1]%MOD);
    }
}