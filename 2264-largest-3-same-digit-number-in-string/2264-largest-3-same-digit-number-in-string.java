class Solution {
    private List<String> sameDigits = List.of("999","888","777","666","555","444","333","222","111","000");

    private boolean contains(String sameDigit, String num){
        for(int ind = 0;ind<=num.length()-3;ind++){
            if(num.charAt(ind)==sameDigit.charAt(0) &&
                num.charAt(ind+1)==sameDigit.charAt(1) &&
                num.charAt(ind+2)==sameDigit.charAt(2)){
                    return true;
                }
        }
        return false;
    }
    public String largestGoodInteger(String num) {
        for(String sameDigit : sameDigits){
            if(contains(sameDigit, num)){
                return sameDigit;
            }
        }
        return "";
    }
}