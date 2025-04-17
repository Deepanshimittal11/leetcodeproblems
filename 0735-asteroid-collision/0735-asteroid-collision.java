class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int a : asteroids){
            collision : {
                while(!st.isEmpty() && st.peek()>0 && a<0){
                    if(st.peek()< -a){
                        st.pop();
                        continue;
                    }
                    else if(st.peek() == -a){
                        st.pop();
                    }
                    break collision;
                }
                st.push(a);
            }
        }

        int[] res = new int[st.size()];
        for(int i=res.length-1;i>=0;i--){
            res[i] = st.pop();
        }
        return res;
    }
}