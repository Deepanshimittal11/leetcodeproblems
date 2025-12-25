class Solution {
    ArrayList<ArrayList<int[]>> adj;
    public int networkDelayTime(int[][] times, int n, int k) {
        adj = new ArrayList<>();
        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());
        for(int[] t : times){
            adj.get(t[0]).add(new int[]{t[1],t[2]});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        pq.offer(new int[]{k,0});

        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int u = curr[0];
            int w = curr[1];
            if(w > dist[0]) continue;
            for(int[] it : adj.get(u)){
                int v = it[0];
                int wt = w + it[1];
                if(dist[v] > wt){
                    pq.offer(new int[]{v, wt});
                    dist[v] = wt;
                }
            }
        }
        int ans = -1;
        for(int i=1;i<=n;i++){
            if(dist[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, dist[i]);
        }
        return ans;
    }
}