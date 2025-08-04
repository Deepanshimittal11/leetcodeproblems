class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int suma = 0, sumb = 0;
        for(int a : aliceSizes) suma += a;
        for(int b : bobSizes) sumb += b;
        int diff = (sumb-suma)/2;

        Set<Integer> set = new HashSet<>();
        for(int b : bobSizes){
            set.add(b);
        }
        for(int a : aliceSizes){
            int b = a + diff;
            if(set.contains(b)){
                return new int[]{a,b};
            }
        }
        return new int[]{};
    }
}