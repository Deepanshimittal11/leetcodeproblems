class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int sum = 0;
        for(String str : operations){
            if(str.equals("X++") || str.equals("++X")) sum++;
            else sum--;
        }
        return sum;
    }
}