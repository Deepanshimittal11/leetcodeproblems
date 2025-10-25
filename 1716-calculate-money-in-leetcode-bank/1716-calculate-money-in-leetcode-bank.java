class Solution {
    public int totalMoney(int n) {
        // first monday = 1,2,3,4,5,6,7
        // sec monday = 2,3,4,5,6,7,8
        // ans so on..
        // arr[] = {1,2,3,4,5,6,7, 2,3,4,5,6,7,8, 3,4,5,6,7,8,9, ....}
        // arr[] = {1 to 1+6 , 2 to 2+6, 3 to 3+6, ....}
        // arr[] = {21-0+7, 28-1+8, 28-2-1+8+9, ...}
        int fullweek = n/7;
        int remainingdays = n%7;
        int sum = 0;
        for(int i=0;i<fullweek;i++){
            sum += 28+(i*7);
        }
        for(int i=0;i<remainingdays;i++){
            sum += fullweek+1+i;
        }
        return sum;
    }
}