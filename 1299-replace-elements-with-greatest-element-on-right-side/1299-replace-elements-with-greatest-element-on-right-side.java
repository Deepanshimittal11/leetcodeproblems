class Solution {
    public int[] replaceElements(int[] arr) {
        int maxelem = -1;
        int[] ans = new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            ans[i] = maxelem;
            maxelem = Math.max(maxelem, arr[i]);
        }
        return ans;
    }
}