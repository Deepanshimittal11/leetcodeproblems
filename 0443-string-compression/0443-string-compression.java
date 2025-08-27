class Solution {
    public int compress(char[] chars) {
        int l = 0;
        int i=0;
        if(chars.length<2) return chars.length;
        while(i<chars.length){
            int cnt = 0;
            char curr = chars[i];
            while(i<chars.length && curr==chars[i]){
                cnt++;
                i++;
            }
            chars[l++] = curr;
            if(cnt>1){
                for(char c : Integer.toString(cnt).toCharArray()){
                    chars[l++] = c;
                }
            }
        }
        return l;
    }
}