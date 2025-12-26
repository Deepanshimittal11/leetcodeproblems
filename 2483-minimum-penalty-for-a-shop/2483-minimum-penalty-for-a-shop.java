class Solution {
    public int bestClosingTime(String customers) {
        int penalty = 0;
        int n = customers.length();
        for(char ch : customers.toCharArray()){
            if(ch == 'Y') penalty++;
        }

        int minpen = penalty;
        int ans = 0;

        for(int i=0;i<n;i++){
            char ch = customers.charAt(i);
            if(ch == 'Y') penalty--;
            else penalty++;
            if(penalty < minpen){
                minpen = penalty;
                ans = i+1;
            }
        }
        return ans;
    }
}