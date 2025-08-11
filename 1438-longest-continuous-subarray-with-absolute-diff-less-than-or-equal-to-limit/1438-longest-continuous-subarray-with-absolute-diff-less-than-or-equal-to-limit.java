class Solution {
    public int longestSubarray(int[] nums, int limit) {

        Deque<Integer> max = new LinkedList<>();
        Deque<Integer> min = new LinkedList<>();
        int len = 0;
        int r = 0;
        for(int i=0;i<nums.length;i++){
            while(!max.isEmpty() && nums[i]>max.peekLast()){
                max.pollLast();
            }
            max.offerLast(nums[i]);
            while(!min.isEmpty() && nums[i]<min.peekLast()){
                min.pollLast();
            }
            min.offerLast(nums[i]);
            while((max.peekFirst()-min.peekFirst())>limit){
                if(max.peekFirst()==nums[r]) max.pollFirst();
                if(min.peekFirst()==nums[r]) min.pollFirst();
                r++;
            }
            len = Math.max(len, i-r+1);
        }
        return len;
    }
}