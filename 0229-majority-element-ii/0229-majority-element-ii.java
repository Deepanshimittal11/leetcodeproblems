class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        //we'll take elem1 and elem2 as most minimum value b/c nums[i] can be zero.
        int cnt1 = 0, elem1 = Integer.MIN_VALUE;
        int cnt2 = 0, elem2 = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            if(cnt1==0 && nums[i]!=elem2){
                cnt1 = 1;
                elem1 = nums[i];
            }
            else if(cnt2==0 && nums[i]!=elem1){
                cnt2 = 1;
                elem2 = nums[i];
            }
            else if(nums[i] == elem1){
                cnt1++;
            }
            else if(nums[i] == elem2){
                cnt2++;
            }
            else{
                cnt1--;
                cnt2--;
            }
        }

        //now we don't need cnt1 and cnt2, we just need them to know our elem1 and elem2.
        //so we'll make cnt1 and cnt2 = 0;
        cnt1 = 0;
        cnt2 = 0;
        for(int i=0;i<n;i++){
            if(nums[i] == elem1) cnt1++;
            if(nums[i] == elem2) cnt2++;
        }
        if(cnt1 > n/3) ans.add(elem1);
        if(cnt2 > n/3) ans.add(elem2);
        return ans;
    }
}