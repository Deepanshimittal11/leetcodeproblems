class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        // a/b < c/d => cross multiplication. 
        //a*d < c*b.
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (arr[a[0]]*arr[b[1]]-arr[a[1]]*arr[b[0]]));

        int n = arr.length;
        //put all elem in fraction.
        for(int i=0;i<n-1;i++){
            pq.offer(new int[]{i,n-1});
        }
        // pop k-1 small fractions.
        for(int cnt = 0;cnt<k-1;cnt++){
            int[] frac = pq.poll();
            int i = frac[0];
            int j = frac[1];
            if(j-1>i){
                pq.offer(new int[]{i,j-1});
            }
        }
        
        int[] ans = pq.peek();
        return new int[]{arr[ans[0]],arr[ans[1]]};
    }
}