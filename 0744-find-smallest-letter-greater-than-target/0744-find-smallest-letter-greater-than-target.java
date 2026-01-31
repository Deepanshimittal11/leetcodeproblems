class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        Arrays.sort(letters);
        for(int i=0;i<letters.length;i++){
            int ch = letters[i] - 'a';
            int c = target - 'a';
            if(c < ch){
                return letters[i];
            }
        }
        return letters[0];
    }
}