class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        int n = nums2.length;
        Map<Integer, Integer> ngeMap = new HashMap<>();
        for(int i=n-1;i>=0;i--){
            int num = nums2[i];
            while(!st.empty() && st.peek()<= num){
                st.pop();         
            }
            int nge = st.isEmpty() ? -1 : st.peek();
            ngeMap.put(num, nge);
            st.push(num);
        }

        int[] result = new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            result[i] = ngeMap.getOrDefault(nums1[i], -1);
        }
        return result;
    }
}