class Solution {
    public List<Integer> intersection(int[][] nums) {
        Map<Integer, Integer> mpp = new HashMap<>();
        int rows = nums.length;
        for(int[] row : nums){
            Set<Integer> unique = new HashSet<>();
            for(int num : row){
                unique.add(num);
            }
            for(int num : unique){
                mpp.put(num, mpp.getOrDefault(num,0)+1);
            }
        }

        List<Integer> res = new ArrayList<>();
        for(int key : mpp.keySet()){
            if(mpp.get(key)==rows){
                res.add(key);
            }
        }
        Collections.sort(res);
        return res;
    }
}