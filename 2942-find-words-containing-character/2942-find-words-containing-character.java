class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        ArrayList<Integer> arr = new ArrayList<>();
        String word;
        for(int i=0;i<words.length;i++){
            word = words[i];
            for(int j=0;j<word.length();j++){
                if(word.charAt(j)==x){
                    arr.add(i);
                    break;
                }
            }
        }
        return arr;
    }
}