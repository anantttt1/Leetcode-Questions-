class Solution {
    public String firstPalindrome(String[] words) {
        for(String s:words){
            String rev=new StringBuilder(s).reverse().toString();
            if(s.equals(rev)){
                return s;
            }
        }
        return "";
    }
}