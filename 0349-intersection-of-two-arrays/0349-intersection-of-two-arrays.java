class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        List<Integer> ans = new ArrayList<>();

        int i = 0;
        int j = 0;

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        while(i<n && j<m){
            if(nums1[i]<nums2[j]){
                i++;
            }
            else if(nums2[j]<nums1[i]){
                j++;
            }
            else{
                if(ans.isEmpty() || ans.get(ans.size()-1)!=nums1[i]){
                    ans.add(nums1[i]);
                }
                i++;
                j++;
            }            
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}