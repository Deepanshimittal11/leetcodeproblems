class Solution {
    public int[] avoidFlood(int[] rains) {
        Map<Integer, Integer> full = new HashMap<>();
        TreeSet<Integer> dryday = new TreeSet<>();
        int[] ans = new int[rains.length];

        for(int i=0;i<rains.length;i++){
            int lake = rains[i];
            if(lake == 0){
                dryday.add(i);
                //yha "1" bs temperory store kia h.
                ans[i] = 1;
            }else{
                ans[i] = -1;
                if(full.containsKey(lake)){
                    //finding the next dryday when the lake was last filled.
                    Integer dry = dryday.higher(full.get(lake));
                    //it means that lake will flood b/c it gets rain again.
                    if(dry == null){
                        return new int[0];
                    }
                    ans[dry] = lake;
                    dryday.remove(dry);
                }
                full.put(lake, i);
            }
        }
        return ans;
    }
}