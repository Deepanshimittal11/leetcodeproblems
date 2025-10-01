class Solution {
    public int maximumPossibleSize(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[i]>st.peek()){
                st.pop();
            }
            st.push(nums[i]);
        }
        return st.size();
    }
}