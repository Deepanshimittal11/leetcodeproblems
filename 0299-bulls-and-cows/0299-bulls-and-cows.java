class Solution {
    public String getHint(String secret, String guess) {

        //we have to number of bulls & cows.
        int bulls = 0;
        int cows = 0;
        int[] scnt = new int[10];
        int[] gcnt = new int[10];

        //we'll cnt bulls and record non-bull digits
        for(int i=0;i<secret.length();i++){
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if(g==s){
                bulls++;
            }else{
                scnt[s-'0']++;
                gcnt[g-'0']++;
            }
        }

        //cnt cows
        for(int d=0;d<10;d++){
            cows += Math.min(scnt[d],gcnt[d]);
        }
        
        return bulls + "A" + cows + "B";
    }
}