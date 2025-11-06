class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++) graph.add(new ArrayList<>());

        int[] indegree = new int[n];
        for(int[] pre : prerequisites){
            int a = pre[0], b=pre[1];
            graph.get(b).add(a);
            indegree[a]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0) q.offer(i);
        }

        int[] toposort = new int[n];
        int ind = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            toposort[ind++] = node;
            for(int neigh : graph.get(node)){
                indegree[neigh]--;
                if(indegree[neigh]==0) q.offer(neigh);
            }
        }
        if(ind==n){
            return toposort;
        }
        
        return new int[0];
    }
}