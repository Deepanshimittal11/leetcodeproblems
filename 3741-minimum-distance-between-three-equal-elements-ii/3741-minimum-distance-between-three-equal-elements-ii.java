class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        if(n<3) return -1;

        Map<Integer, List<Integer>> mpp = new HashMap<>();
        for(int i=0;i<n;i++){
            mpp.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        int mindis = Integer.MAX_VALUE;
        for(List<Integer> value : mpp.values()){
            if(value.size()<3) continue;
            for(int i=0;i+2<value.size();i++){
                int dis = 2 * (value.get(i+2)-value.get(i));
                mindis = Math.min(mindis, dis);
            }
        }
        return mindis == Integer.MAX_VALUE ? -1 : mindis;
    }
}