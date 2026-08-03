class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // if(n==0) return;
        // else if(m==0){
        //     for(int i=0;i<n;i++){
        //         nums1[i] = nums2[i];
        //     }
        // }

        //brute force:
        // int ind=0;
        // for(int i=nums1.length-1; i>=0 && ind<n; i--){
        //     nums1[i] = nums2[ind++];
        // }
        // Arrays.sort(nums1);

        //optimize way:
        int k = m+n-1;
        int i = m-1;
        int j = n-1;
        while(i>=0 && j>=0){
            if(nums1[i]>nums2[j]){
                nums1[k] = nums1[i];
                i--;
            }
            else{
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
        while(j>=0){
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}