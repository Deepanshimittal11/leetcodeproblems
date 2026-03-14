class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] list = new int[2*n];
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<n;i++){
            list[i] = nums[i];
            list[i+n] = nums[i];
        }

        //nums = [1,2,1];
        //list = [1,2,1,1,2,1];

        List<Integer> temp = new ArrayList<>();
        int m = list.length;

        for(int i=m-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=list[i]){
                st.pop();
            }

            if(st.isEmpty()){
                temp.add(-1);
            }
            else{
                temp.add(st.peek());
            }
            st.push(list[i]);
        }

        int[] ans = new int[n];
        Collections.reverse(temp);
        for(int i=0;i<n;i++){
            ans[i] = temp.get(i);
        }
        return ans;
    }
}