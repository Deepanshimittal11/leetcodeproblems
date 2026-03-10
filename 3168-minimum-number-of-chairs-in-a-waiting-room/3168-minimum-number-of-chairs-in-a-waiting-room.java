class Solution {
    public int minimumChairs(String s) {
        int n = s.length();
        int enter = 0;
        int maxE = 0;
        
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(ch == 'E'){
                enter++;
            }
            else{
                enter--;
            }
            maxE = Math.max(maxE, enter);
        }
        return maxE;
    }
}