class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<int[]> mheap = new PriorityQueue<>((a,b)-> a[0]-b[0]);

        if(nums1.length==0 || nums2.length==0 || k==0) return ans;

        for(int i=0;i<Math.min(nums1.length,k);i++){
            mheap.offer(new int[]{nums1[i]+nums2[0],i,0});
        }
        while(k-->0 && !mheap.isEmpty()){
            int[] curr = mheap.poll();
            int i= curr[1];
            int j = curr[2];
            ans.add(Arrays.asList(nums1[i],nums2[j]));
            if(j+1<nums2.length){
                mheap.offer(new int[]{nums1[i]+nums2[j+1],i,j+1});
            }
        }
        return ans;
    }
}