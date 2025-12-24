class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        //n pack
        //m boxes
        int n = apple.length;
        int m = capacity.length;

        Arrays.sort(capacity);

        int used = 0;
        int totalsum = 0; 
        int sum = 0;

        for(int it : apple) totalsum += it;
        for(int i=m-1;i>=0;i--){
            if(sum >= totalsum) break;
            sum += capacity[i];
            used++;
        }
        return used;
    }
}