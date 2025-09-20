class Solution {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        Map<Integer, Set<Integer>> dp = new HashMap<>();

        for(int stone : stones){
            dp.put(stone, new HashSet<>());
        }

        dp.get(0).add(0);

        for(int stone : stones){
            for(int jump : dp.get(stone)){
                for(int i=jump-1;i<=jump+1;i++){
                    if(i>0 && dp.containsKey(stone+i)){
                        dp.get(stone+i).add(i);
                    }
                }
            }
        }
        return !dp.get(stones[n-1]).isEmpty();
    }
}