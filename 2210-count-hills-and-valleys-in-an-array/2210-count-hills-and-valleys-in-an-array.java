class Solution {
    public int countHillValley(int[] nums) {
        int cnt = 0;
        int n = nums.length;
        List<Integer> arr = new ArrayList<>();
        arr.add(nums[0]);
        for(int i=1;i<n;i++){
            if(nums[i]!=nums[i-1]) arr.add(nums[i]);
        }
        for(int i=1;i<arr.size()-1;i++){
            int last = arr.get(i-1);
            int curr = arr.get(i);
            int next = arr.get(i+1);
            if((curr>last && curr>next) || (curr<last && curr<next)){
                cnt++;
            }
        }
        return cnt;
    }
}