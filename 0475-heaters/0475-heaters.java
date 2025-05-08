class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int range = 0;
        for(int i=0;i<houses.length;i++){
            int mindis = Integer.MAX_VALUE;
            for(int j=0;j<heaters.length;j++){
                mindis = Math.min(mindis, Math.abs(houses[i]-heaters[j]));
            }
            range = Math.max(range, mindis);
        }
        return range;
    }
}