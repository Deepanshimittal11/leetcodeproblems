class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] circularArr = new int[2*n];
        for(int i=0;i<n;i++){
            circularArr[i] = nums[i];
            circularArr[n+i] = nums[i];
        }

        int[] ans = new int[2*n];
        Stack<Integer> st = new Stack<>();
        for(int i=ans.length-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=circularArr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                ans[i] = -1;
            }
            else if(st.peek() > circularArr[i]){
                ans[i] = st.peek();
            }
            st.push(circularArr[i]);
        }
        ans = Arrays.copyOfRange(ans, 0, n);
        return ans;
    }
}