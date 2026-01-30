class Solution {
    public long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
        int n = source.length();
        long inf = (long)1e18;

        Set<String> set = new HashSet<>();
        for(String og : original) set.add(og);
        for(String ch : changed) set.add(ch);

        List<String> arr = new ArrayList<>(set);
        int m = arr.size();

        Map<String, Integer> mpp = new HashMap<>();
        for(int i=0;i<m;i++){
            mpp.put(arr.get(i),i);
        }

        long[][] dist = new long[m][m];
        for(int i=0;i<m;i++){
            Arrays.fill(dist[i], inf);
            dist[i][i] = 0;
        }

        for(int i=0;i<original.length;i++){
            int u = mpp.get(original[i]);
            int v = mpp.get(changed[i]);
            dist[u][v] = Math.min(dist[u][v], cost[i]);
        }

        for(int k=0;k<m;k++){
            for(int i=0;i<m;i++){
                if(dist[i][k] == inf) continue;
                for(int j=0;j<m;j++){
                    if(dist[k][j] == inf) continue;
                    dist[i][j] = Math.min(dist[i][j], (dist[i][k] + dist[k][j]));
                }
            }
        }

        Set<Integer> Set = new HashSet<>();
        for(String s : original) Set.add(s.length());

        long[] dp = new long[n+1];
        Arrays.fill(dp, inf);
        dp[0] = 0;

        for(int i=0;i<n;i++){
            if(dp[i] == inf) continue;
            if(source.charAt(i)==target.charAt(i)) dp[i+1] = Math.min(dp[i+1],dp[i]);
            for(int len : Set){
                if(i+len > n) continue;
                String ssub = source.substring(i, i+len);
                String tsub = target.substring(i, i+len);
                Integer u = mpp.get(ssub);
                Integer v = mpp.get(tsub);
                if(u!=null && v!=null && dist[u][v]!=inf){
                    dp[i+len] = Math.min(dp[i+len], dp[i]+dist[u][v]);
                }
            }
        }
        return dp[n] == inf ? -1 : dp[n];
    }
}