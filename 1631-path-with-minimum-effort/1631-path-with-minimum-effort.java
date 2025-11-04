class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[][] dist = new int[n][m];
        for(int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        pq.add(new int[]{0,0,0});
        dist[0][0] = 0;

        int[][] dir = {{0,-1},{0,1},{1,0},{-1,0}};

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int effort = curr[0];
            int r = curr[1];
            int c = curr[2];
            if(r==n-1 && c==m-1) return effort;

            for(int[] d : dir){
                int nr = r + d[0], nc = c + d[1];
                if(nr>=0 && nc>=0 && nr<n && nc<m){
                    int curreffort = Math.max(effort, Math.abs(heights[nr][nc]-heights[r][c]));
                    if(curreffort < dist[nr][nc]){
                        dist[nr][nc] = curreffort;
                        pq.offer(new int[]{curreffort, nr, nc});
                    }
                }                
            }
        }
        return 0;
    }
}