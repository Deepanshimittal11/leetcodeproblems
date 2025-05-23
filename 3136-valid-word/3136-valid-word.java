class Solution {
    public boolean isValid(String word) {
        if(word==null || word.length()<3) return false;

        boolean hasVowel = false;
        boolean hasConsonent = false;

        for(char c : word.toCharArray()){
            if(!Character.isLetterOrDigit(c)){
                return false;
            }
            if(Character.isLetter(c)){
                char lowerC = Character.toLowerCase(c);
                if("aeiou".indexOf(lowerC) >= 0){
                    hasVowel = true;
                }
                else{
                    hasConsonent = true;
                }
            }
        }
        return hasVowel && hasConsonent;
    }
}