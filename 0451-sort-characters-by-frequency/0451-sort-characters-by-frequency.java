class Solution {
    public String frequencySort(String s) {

        char[] ch = s.toCharArray(); 
        for(int i=0;i<ch.length;i++){
            if(ch[i]<'z' && ch[i]>'a'){
                Arrays.sort(ch);
            }
        }
        StringBuilder result = new StringBuilder();
        for (Character val : ch) {
            result.append(val);
        }
        
        return result.toString();
    }
}