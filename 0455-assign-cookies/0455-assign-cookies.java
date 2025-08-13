class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int content = 0;
        int ind = 0;
        while(ind < s.length && content < g.length){
            if(s[ind] >= g[content]){
                content++;
            }
            ind++;
        }
        return content;
    }
}