class Solution {
    public int maxProduct(int n) {
        String str = Integer.toString(n);
        //str="124";
        char[] ch = str.toCharArray();
        //ch = ["1","2","4"];
        Arrays.sort(ch);

        int len = ch.length;
        int pdt = (ch[len-1]-'0') * (ch[len-2]-'0');
        return pdt;
    }
}