class Solution {
    public int percentageLetter(String s, char letter) {
        int cnt = 0;
        int n = s.length();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==letter){
                cnt++;
            }
        }
        return (cnt * 100 /n);
    }
}