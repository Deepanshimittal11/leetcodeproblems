class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        int sum = 0;
        int maxsum = 0;
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<banned.length;i++){
            set.add(banned[i]);
        }
        for(int i=1;i<=n;i++){
            if(!set.contains(i)){
                sum += i;
                if(sum > maxSum){
                    break;
                }
                maxsum++ ;
            }
        }
        return maxsum;
    }
}