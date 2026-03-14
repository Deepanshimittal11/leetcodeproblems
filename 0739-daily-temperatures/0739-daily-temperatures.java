class Solution {
    public int[] dailyTemperatures(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];
        
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]<=arr[i]) st.pop();
            
            if(st.isEmpty()){
                result[i] = 0;
            }
            else{
                result[i] = st.peek()-i;
            }
            st.push(i);
        }
        return result;
    }
}