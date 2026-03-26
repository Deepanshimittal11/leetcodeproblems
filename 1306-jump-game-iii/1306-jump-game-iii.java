class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        //we will do this question using level order traversal in which queue will be used.
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        while(!q.isEmpty()){
            int ind = q.poll();
            if(arr[ind]==0) return true;
            if(arr[ind]<0) continue;

            if(ind+arr[ind]<n) q.offer(ind+arr[ind]);
            if(ind-arr[ind]>=0) q.offer(ind-arr[ind]);
            arr[ind] = -arr[ind];
        }
        return false;
    }
}