class Solution {
    public int differenceOfSums(int n, int m) {
        int SumOfNotDiv = 0;
        int SumOfDiv = 0;
        for(int i=1;i<=n;i++){
            if(i%m!=0){
                SumOfNotDiv += i;
            }
            else{
                SumOfDiv += i;
            }
        }
        return (SumOfNotDiv-SumOfDiv);
    }
}