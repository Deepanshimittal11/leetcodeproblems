class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n =strs.length;
        Arrays.sort(strs);

        String first = strs[0];
        String last = strs[n-1];
        //now compare first and last element;
        int i=0, j=0;
        int firstlen = first.length();
        int lastlen = last.length();

        StringBuilder res = new StringBuilder();
        while(i<firstlen && j<lastlen){
            if(first.charAt(i) != last.charAt(j)){
                break;
            }
            res.append(first.charAt(i));
            i++;
            j++;
        }
        return res.toString();
    }
}