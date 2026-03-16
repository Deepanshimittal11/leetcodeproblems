class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n-k+1];
        Deque<Integer> q = new LinkedList<>();
        int ind = 0;
        int i=0, j=0;

        while(j<n){
            while(!q.isEmpty() && q.peekLast()<nums[j]){
                q.pollLast();
            }
            q.addLast(nums[j]);
            if(j-i+1 < k){
                j++;
            }
            else{
                ans[ind++] = q.peekFirst();
                if(q.peekFirst()==nums[i]){
                    q.pollFirst();
                }
                i++;
                j++;
            }
        }
        return ans;
    }
}