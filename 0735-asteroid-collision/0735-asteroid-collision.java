class Solution {
    public int[] asteroidCollision(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<n;i++){
            if(arr[i]>0) st.push(arr[i]);
            else{
                boolean destroy = false;
                while(!st.isEmpty() && st.peek()>0 && Math.abs(arr[i]) > st.peek()){
                    st.pop();
                }
                if(!st.isEmpty() && st.peek()==Math.abs(arr[i])){
                    st.pop();
                    destroy = true;
                }
                else if(!st.isEmpty() && st.peek()>Math.abs(arr[i])){
                    destroy = true;
                }
                if(!destroy){
                    st.push(arr[i]);
                }
            }
        }

        int[] ans = new int[st.size()];
        int i=st.size()-1;
        while(!st.isEmpty()){
            ans[i--] = st.pop();
        }
        return ans;
    }
}