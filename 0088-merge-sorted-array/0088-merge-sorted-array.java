class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums1.length == m && n==0) return;

        int ind = 0;
        for(int i=nums1.length-1;i>=0 && ind<n;i--){
            nums1[i] = nums2[ind++];
        }
        Arrays.sort(nums1);
    }
}